package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.OwnerPOJO;
import co.edu.unbosque.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OwnerPOJO owner) {

        Optional<OwnerPOJO> persistedOwner = new OwnerService().createOwner(owner);

        if (persistedOwner.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOwner.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("No se pudo crear el propietario")
                    .build();
        }
    }

    @PUT
    @Path("/{owner}/{update}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("owner") String owner, @PathParam("update") String update, OwnerPOJO ownerPOJO){
        Optional<OwnerPOJO> persistedOwner = null;

        if (owner.equals("owner") && update.equals("email")){
            persistedOwner = Optional.of(new OwnerService().updateEmail(ownerPOJO.getEmail(), ownerPOJO.getUsername()));
        }else if (owner.equals("owner") && update.equals("address")){
            persistedOwner = Optional.of(new OwnerService().updateAddress(ownerPOJO.getAddress(), ownerPOJO.getUsername()));
        }else if (owner.equals("owner") && update.equals("neighborhood")){
            persistedOwner = Optional.of(new OwnerService().updateNeighborhood(ownerPOJO.getNeighborhood(), ownerPOJO.getUsername()));
        }else{
            persistedOwner = null;
        }
        if (persistedOwner.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

}