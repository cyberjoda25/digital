package ec.com.dinersclub.dddmodules.infrastructure.conectores;

import ec.com.dinersclub.dddmodules.infrastructure.providers.AS400ProviderMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/v2")
@RegisterProvider(value = AS400ProviderMapper.class, priority = 50)
@RegisterRestClient(configKey = "conectorAs400-api")
public interface ConectorAs400Service {

    @POST
    @PermitAll
    @Path("/AS400/ejecutar")
    Response ejecutarAS400(String jsonIn);

}