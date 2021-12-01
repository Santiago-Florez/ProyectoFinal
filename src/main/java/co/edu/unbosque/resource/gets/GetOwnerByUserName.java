package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.OwnerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners/{username}")
public class GetOwnerByUserName {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("username") String username){
        Optional persitedOwner = Optional.of(new OwnerService().findUsername(username));

        if (persitedOwner.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedOwner.get()).build();
        }else{
            return Response.status(400).build();
        }
    }
}
