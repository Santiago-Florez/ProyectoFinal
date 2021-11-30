package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.OfficialService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/officials/{username}")
public class GetOfficialByUserName {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("username") String username){
        Optional persitedOfficial = Optional.of(new OfficialService().findUsername(username));

        if (persitedOfficial.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedOfficial.get()).build();
        }else{
            return Response.status(400).build();
        }
    }
}
