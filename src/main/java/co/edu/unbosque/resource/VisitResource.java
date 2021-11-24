package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.PetPOJO;
import co.edu.unbosque.resource.pojo.VisitPOJO;
import co.edu.unbosque.services.PetService;
import co.edu.unbosque.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/visits")
public class VisitResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPOJO visitPOJO){
        Optional<VisitPOJO> persistedVisit = Optional.of(new VisitService().createVisit(
                visitPOJO.getVisitId(), visitPOJO.getCreatedAt(), visitPOJO.getType(), visitPOJO.getDescription(),
                visitPOJO.getVetId(), visitPOJO.getPetId()));
        if (persistedVisit.isPresent()){
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVisit.get())
                    .build();
        }else {
            return Response.serverError()
                    .entity("No se pudo crear la mascota")
                    .build();
        }
    }

    @PUT
    @Path("/{visit}/{microchip}/{newMicro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("visit") String pet, @PathParam("microchip") String update,
            @PathParam("newMicro") String newMicro, VisitPOJO petPOJO){
        Optional<PetPOJO> persistedPet = null;

        if(pet.equals("visit") && update.equals("microchip")){
            if (petPOJO.getType().equals("microchip")){
                persistedPet = Optional.of(new PetService().updateMicrochip(newMicro, petPOJO.getPetId()));
            }else{
                persistedPet = null;
            }
        }else{
            persistedPet = null;
        }
        if (persistedPet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }
}
