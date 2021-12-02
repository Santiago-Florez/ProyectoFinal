package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.VisitService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/visitsList")
public class GetVisits {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisits(){
        Optional persitedVisits = Optional.of(new VisitService().findAll());
        return Response.ok(persitedVisits.get()).build();
    }

    @GET
    @Path("{petId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitsByPetName(@PathParam("petId") Integer petId){
        Optional persitedVisits = Optional.of(new VisitService().findPetId(petId));

        if (persitedVisits.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedVisits.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("visitNamePet/{namePet}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitPetId(@PathParam("namePet") String namePet){
        Optional persistedVisit = Optional.of(new VisitService().findVisitPetId(namePet));

        if (persistedVisit.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedVisit.get()).build();
        }else{
            return Response.status(404).build();
        }
    }
}
