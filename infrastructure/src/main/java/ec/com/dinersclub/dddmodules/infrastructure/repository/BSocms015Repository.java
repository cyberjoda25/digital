package ec.com.dinersclub.dddmodules.infrastructure.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.infrastructure.conectores.ConectorAs400Service;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.BSocms015Properties;
import ec.com.dinersclub.dddmodules.infrastructure.extensiones.ObjectExt;
import ec.com.dinersclub.dddmodules.infrastructure.model.socms015.DinBodyBSocms015;
import ec.com.dinersclub.dto.FactoryAS400;
import ec.com.dinersclub.dto.HeaderAS400;
import ec.com.dinersclub.dto.IDinError;
import ec.com.dinersclub.dto.RequestAS400;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseAS400;
import ec.com.dinersclub.excepciones.MicroservicioError;
import ec.com.dinersclub.excepciones.MicroservicioExcepcion;

@ApplicationScoped
public class BSocms015Repository {

    private static final String CODIGO_EXITOSO = "0000";

    @Inject
    BSocms015Properties bsocms015Properties;

    @Inject
    @RestClient
    ConectorAs400Service conectorAs400Service;

    private final ObjectMapper mapper;

    public BSocms015Repository() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public DinBodyBSocms015 ejecutarBSOCMS15(RequestMs<DinBodyRequestInformacionIndividual> query) {

        HeaderAS400 header = new FactoryAS400().mapearDinHeader(query.getDinHeader());
        header.setComandoRPG(bsocms015Properties.getComandoRPG());
        header.setHostname(bsocms015Properties.getHostname());
        header.setLibraryList(bsocms015Properties.getLibraryList());
        header.setLimpiarCache(bsocms015Properties.getLimpiarCache());
        header.setModuloRPG(bsocms015Properties.getModuloRPG());
        header.setPrograma(bsocms015Properties.getPrograma());
        header.setRutaPath(bsocms015Properties.getRutaPath());

        var dinBodyRequest = new DinBodyBSocms015(query.getDinBody().getTipoIdentificacion(), query.getDinBody().getIdentificacion());

        RequestAS400<DinBodyBSocms015> requestAs400 = new RequestAS400<>(header, dinBodyRequest);
        requestAs400.getDinBody().setPortal(query.getDinHeader().getPortalId());
        Response response = this.conectorAs400Service.ejecutarAS400(ObjectExt.toJson(requestAs400));

        ResponseAS400<DinBodyBSocms015> responseAS400 = this.crearResponseBSocms015(response);

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

    private ResponseAS400<DinBodyBSocms015> crearResponseBSocms015(Response response) {
        try {
            return this.mapper.readValue(response.readEntity(ObjectNode.class).toString(),
                    new TypeReference<ResponseAS400<DinBodyBSocms015>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new MicroservicioExcepcion(e, "Crear response Socms083");
        }
    }


}
