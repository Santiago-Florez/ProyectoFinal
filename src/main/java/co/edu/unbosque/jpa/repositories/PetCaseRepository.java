package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.PetCase;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<PetCase> saveType(PetCase pet);

    List<PetCase> findAll();
}
