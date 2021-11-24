package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> save(Visit visit);

    List<Visit> findAll();

    Optional<Pet> updatePetMicrochip(String microchip, Integer petId);
}
