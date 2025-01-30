package ec.com.dinersclub.dddmodules.application.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.com.dinersclub.dddmodules.application.cqrs.queries.IInformacionIndividualQueryService;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyResponseInformacionIndividual;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.ExcepcionMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;
import ec.com.dinersclub.logs.anotaciones.DinLogger;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.extension.annotations.WithSpan;

@Path("/cliente/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InformacionIndividualResource {

	@Inject
	IInformacionIndividualQueryService iInformacionIndividualQueryService;

	@WithSpan(kind = SpanKind.SERVER)
	@POST
	@PermitAll
	@Path("/gestion-datos/informacion-individual/consulta")
	@DinLogger
	public Response consultarInformacionIndividual(RequestMs<DinBodyRequestInformacionIndividual> query) {

		ResponseMs<DinBodyResponseInformacionIndividual> response;
		Response respuesta;

		try {

			respuesta = Response.ok().entity(iInformacionIndividualQueryService.consultarInformacionIndividualCliente(query)).build();

		} catch (AbstractMsExcepcion ex) {
			response = new ResponseMs<>(query.getDinHeader(), ex.getDinError());
			respuesta = Response.status(ex.getCodigoHttp()).entity(response).build();

		} catch (Exception ex) {
			response = new ResponseMs<>(query.getDinHeader(), ExcepcionMs.procesar(ex));
			respuesta = Response.serverError().entity(response).build();
		}

		return respuesta;
	}

}