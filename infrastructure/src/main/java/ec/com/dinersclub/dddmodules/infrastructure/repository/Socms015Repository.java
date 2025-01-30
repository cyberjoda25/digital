package ec.com.dinersclub.dddmodules.infrastructure.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.infrastructure.conectores.ConectorAs400Service;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.ObjectExt;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.Socms015Properties;
import ec.com.dinersclub.dddmodules.infrastructure.model.socms015.DinBodyBSocms015;
import ec.com.dinersclub.dddmodules.infrastructure.model.socms015.DinBodySocms015;
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
public class Socms015Repository {

    private static final String CODIGO_EXITOSO = "0000";

    @Inject
    Socms015Properties socms015Properties;

    @Inject
    @RestClient
    ConectorAs400Service conectorAs400Service;

    private final ObjectMapper mapper;

    public Socms015Repository() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public DinBodySocms015 ejecutarSOCMS15(RequestMs<DinBodyRequestInformacionIndividual> query) {

        HeaderAS400 header = new FactoryAS400().mapearDinHeader(query.getDinHeader());
        header.setComandoRPG(socms015Properties.getComandoRPG());
        header.setHostname(socms015Properties.getHostname());
        header.setLibraryList(socms015Properties.getLibraryList());
        header.setLimpiarCache(socms015Properties.getLimpiarCache());
        header.setModuloRPG(socms015Properties.getModuloRPG());
        header.setPrograma(socms015Properties.getPrograma());
        header.setRutaPath(socms015Properties.getRutaPath());

        var dinBodyRequest = new DinBodySocms015(query.getDinBody().getTipoIdentificacion(), query.getDinBody().getIdentificacion());

        RequestAS400<DinBodySocms015> requestAs400 = new RequestAS400<>(header, dinBodyRequest);
        Response response = this.conectorAs400Service.ejecutarAS400(ObjectExt.toJson(requestAs400));

        ResponseAS400<DinBodySocms015> responseAS400 = this.crearResponseSocms015(response);

        IDinError dinError = responseAS400.getDinError();

        if (!responseAS400.getDinBody().getCodigoError().isEmpty()) {
            throw new MicroservicioError(responseAS400.getDinBody().getCodigoError(), responseAS400.getDinBody().getDescripcionError());
        }

        if (!dinError.getCodigo().equals(CODIGO_EXITOSO)) {
            throw new MicroservicioError(dinError.getCodigo(), dinError.getMensaje());
        }
        if (responseAS400.getDinBody().getHayError().equals("1")){
            throw new MicroservicioError(responseAS400.getDinBody().getCodigoError(), responseAS400.getDinBody().getDescripcionError());
        }

        return responseAS400.getDinBody();
    }

    private ResponseAS400<DinBodySocms015> crearResponseSocms015(Response response) {
        try {
            return this.mapper.readValue(response.readEntity(ObjectNode.class).toString(),
                    new TypeReference<ResponseAS400<DinBodySocms015>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new MicroservicioExcepcion(e, "Crear response Socms083");
        }
    }


}
