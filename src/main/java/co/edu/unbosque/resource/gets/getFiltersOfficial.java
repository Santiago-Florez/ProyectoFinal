package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.OfficialService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/filtersOfficial")
public class getFiltersOfficial {

    @GET
    @Path("/ownerLocalidad/{ownerLocalidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ownersNeighborhood(@PathParam("ownerLocalidad") String localidad){
        Optional persistedownerNeighborhood = Optional.of(new OfficialService().findOwnerLocalidad(localidad));
        if (persistedownerNeighborhood.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedownerNeighborhood.get()).build();
        }else{
            return Response.status(400).build();
        }
    }

    @GET
    @Path("/petSpecies/{petSpecies}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response petSpecies(@PathParam("petSpecies") String specie){
        Optional persistedpetSpecies = Optional.of(new OfficialService().findBySpecie(specie));
        if (persistedpetSpecies.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedpetSpecies.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/statusMicrochip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response statusMicrochip(){
        Optional persistedstatusMicrochip = Optional.of(new OfficialService().findPetByStatusMicrochip());
        if (persistedstatusMicrochip.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedstatusMicrochip.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/sterilization/{sterilization}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sterilization(@PathParam("sterilization") String sterilization){
        Optional persitedsterilization = Optional.of(new OfficialService().findPetByStatusSterilization(sterilization));
        if (persitedsterilization.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedsterilization.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/caseType/{caseType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caseType(@PathParam("caseType") String caseType){
        Optional persitedcaseType = Optional.of(new OfficialService().findCaseByType(caseType));
        if (persitedcaseType.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedcaseType.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/vetName/{vetName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response vetName(@PathParam("vetName") String vetName){
        Optional persistedvetName = Optional.of(new OfficialService().findByVetName(vetName));
        if (persistedvetName.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedvetName.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/visitType/{visitType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response visitType(@PathParam("visitType") String visitType){
        Optional persistedvisitName = Optional.of(new OfficialService().findVisitByType(visitType));
        if (persistedvisitName.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedvisitName.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

}