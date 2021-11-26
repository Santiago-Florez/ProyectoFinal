package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.PetPOJO;
import co.edu.unbosque.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/pets")
public class PetResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetPOJO petPOJO){
        Optional<PetPOJO> persistedPet = Optional.of(new PetService().createdPet(petPOJO.getPet_id(), petPOJO.getMicrochip(), petPOJO.getName(), petPOJO.getSpecies(),
                petPOJO.getRace(), petPOJO.getSize(), petPOJO.getSex(), petPOJO.getPicture(), petPOJO.getOwnerId()));
        if (persistedPet.isPresent()){
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPet.get())
                    .build();
        }else {
            return Response.serverError()
                    .entity("No se pudo crear la mascota")
                    .build();
        }
    }

    @GET
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("ownerId") String ownerIdParam){
        Integer ownerId = Integer.parseInt(ownerIdParam);
        Optional persistedPet = Optional.of(new PetService().findOwnerId(ownerId));

        if (persistedPet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

    @PUT
    @Path("/{pet}/{update}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("pet") String pet, @PathParam("update") String update, PetPOJO petPOJO){
        Optional<PetPOJO> persistedPet = null;

        if(pet.equals("pet") && update.equals("name")){
            persistedPet = Optional.of(new PetService().updateName(petPOJO.getName(), petPOJO.getPet_id()));
        }else if(pet.equals("pet") && update.equals("species")){
            persistedPet = Optional.of(new PetService().updateSpecies(petPOJO.getSpecies(), petPOJO.getPet_id()));
        }else if(pet.equals("pet") && update.equals("race")){
            persistedPet = Optional.of(new PetService().updateRace(petPOJO.getRace(), petPOJO.getPet_id()));
        }else if(pet.equals("pet") && update.equals("size")){
            persistedPet = Optional.of(new PetService().updateSize(petPOJO.getSize(), petPOJO.getPet_id()));
        }else if(pet.equals("pet") && update.equals("sex")){
            persistedPet = Optional.of(new PetService().updateSex(petPOJO.getSex(), petPOJO.getPet_id()));
        }else if(pet.equals("pet") && update.equals("picture")){
            persistedPet = Optional.of(new PetService().updatePicture(petPOJO.getPicture(), petPOJO.getPet_id()));
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
