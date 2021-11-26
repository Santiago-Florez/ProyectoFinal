package co.edu.unbosque.resource;

import co.edu.unbosque.services.VetService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets/{username}")
public class GetVetByUserName {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("username") String username){
        Optional persitedVet = Optional.of(new VetService().findUsername(username));

        if (persitedVet.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedVet.get()).build();
        }else{
            return Response.status(400).build();
        }
    }
}
