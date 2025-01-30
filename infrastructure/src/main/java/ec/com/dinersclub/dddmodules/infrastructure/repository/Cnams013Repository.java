package ec.com.dinersclub.dddmodules.infrastructure.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.infrastructure.conectores.ConectorAs400Service;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.Cnams013Properties;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.ObjectExt;
import ec.com.dinersclub.dddmodules.infrastructure.model.cnams013.DinBodyCnams013;
import ec.com.dinersclub.dddmodules.infrastructure.model.cnams013.DinBodyResponseCnams013;
import ec.com.dinersclub.dddmodules.infrastructure.model.cnams013.Priminds;
import ec.com.dinersclub.dddmodules.infrastructure.model.cnams013.Primoutds;
import ec.com.dinersclub.dto.FactoryAS400;
import ec.com.dinersclub.dto.HeaderAS400;
import ec.com.dinersclub.dto.IDinError;
import ec.com.dinersclub.dto.RequestAS400;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseAS400;
import ec.com.dinersclub.excepciones.MicroservicioError;
import ec.com.dinersclub.excepciones.MicroservicioExcepcion;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class Cnams013Repository {


    private static final String CODIGO_EXITOSO = "0000";

    @Inject
    Cnams013Properties cnams013Properties;

    @Inject
    @RestClient
    ConectorAs400Service conectorAs400Service;

    private final ObjectMapper mapper;

    public Cnams013Repository() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Primoutds ejecutarCnams013(RequestMs<DinBodyRequestInformacionIndividual> query) {

        HeaderAS400 header = new FactoryAS400().mapearDinHeader(query.getDinHeader());
        header.setComandoRPG(cnams013Properties.getComandoRPG());
        header.setHostname(cnams013Properties.getHostname());
        header.setLibraryList(cnams013Properties.getLibraryList());
        header.setLimpiarCache(cnams013Properties.getLimpiarCache());
        header.setModuloRPG(cnams013Properties.getModuloRPG());
        header.setPrograma(cnams013Properties.getPrograma());
        header.setRutaPath(cnams013Properties.getRutaPath());
        var dinBodyCnams013 = new DinBodyCnams013();

        var dinBodyRequest = new Priminds(query.getDinBody().getIdentificacion(), query.getDinBody().getTipoIdentificacion());
        dinBodyCnams013.setPriminds(dinBodyRequest);

        RequestAS400<DinBodyCnams013> requestAs400 = new RequestAS400<>(header, dinBodyCnams013);

        Response response = this.conectorAs400Service.ejecutarAS400(ObjectExt.toJson(requestAs400));

        ResponseAS400<DinBodyResponseCnams013> responseAS400 = this.crearResponseCnams013(response);

        IDinError dinError = responseAS400.getDinError();

        if (!dinError.getCodigo().equals(CODIGO_EXITOSO)) {
            throw new MicroservicioError(dinError.getCodigo(), dinError.getMensaje());
        }

        return responseAS400.getDinBody().getPrimoutds();
    }

    private ResponseAS400<DinBodyResponseCnams013> crearResponseCnams013(Response response) {
        try {
            return this.mapper.readValue(response.readEntity(ObjectNode.class).toString(),
                    new TypeReference<ResponseAS400<DinBodyResponseCnams013>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new MicroservicioExcepcion(e, "Crear response Cnams013");
        }
    }

}
