package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.PetService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/petsList")
public class GetPets {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        Optional persistedPet = Optional.of(new PetService().findAll());
        return Response.ok(persistedPet.get()).build();
    }

    @GET
    @Path("{petId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetId(@PathParam("petId") Integer petId){
        Optional persistedOwner = Optional.of(new PetService().findPetId(petId));
        return Response.ok(persistedOwner.get()).build();
    }
}
