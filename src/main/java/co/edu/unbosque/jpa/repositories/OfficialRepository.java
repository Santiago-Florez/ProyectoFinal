package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.*;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> create(Official off);

    Optional<Official> findByOwnerId(String officialId);

    List<Official> findAll();

    Optional<Official> updateName(String name, String username);

    Optional<Official> updateEmail(String email, String username);

    List<Owner> findOwnerLocalidad(String localidad);

    List<Pet> findPetBySpecies(String specie);

    List<Pet> findPetByStatusMicrochip();

    List<Visit> findPetByStatusSterilization(String sterilization);

    List<PetCase> findCaseByType(String type);

    List<Visit> findByVetName(String vetName);

    List<Visit> findVisitByType(String type);
}
