package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.VetPOJO;
import co.edu.unbosque.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets")
public class VetResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VetPOJO vet) {

        Optional<VetPOJO> persistedVet = new VetService().createVet(vet);

        if (persistedVet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVet.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }

    }

    @PUT
    @Path("/{vet}/{update}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("vet") String vet, @PathParam("update") String update, VetPOJO vetPOJO){
        Optional<VetPOJO> persistedVet = null;

        if(vet.equals("vet") && update.equals("name")){
            persistedVet = Optional.of(new VetService().updateName(vetPOJO.getName(), vetPOJO.getUsername()));
        }else if (vet.equals("vet") && update.equals("address")){
            persistedVet = Optional.of(new VetService().updateAddress(vetPOJO.getAddress(), vetPOJO.getUsername()));
        }else if (vet.equals("vet") && update.equals("neighborhood")){
            persistedVet = Optional.of(new VetService().updateNeighborhood(vetPOJO.getNeighborhood(), vetPOJO.getUsername()));
        }else{
            persistedVet = null;
        }
        if (persistedVet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

    @PUT
    @Path("/{vet}/{update}/{update2}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("vet") String vet, @PathParam("update") String update, @PathParam("update2") String update2, VetPOJO vetPOJO){
        Optional<VetPOJO> persistedVet = null;

        if (vet.equals("vet") && update.equals("address") && update2.equals("neighborhood")){
            persistedVet = Optional.of(new VetService().updateAddressAndNeighborhood(vetPOJO.getAddress(), vetPOJO.getNeighborhood(), vetPOJO.getUsername()));
        }else{
            persistedVet = null;
        }
        if (persistedVet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }



}
