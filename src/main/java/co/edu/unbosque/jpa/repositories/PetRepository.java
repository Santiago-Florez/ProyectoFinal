package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Pet> save(Pet pet);

    List<Pet> findAll();

    Optional<Pet> updatePetMicrochip(String microchip, Integer petId);

    Optional<Pet> findId(Integer id);

    Optional<Pet> findOwnerId(Integer id);

    Optional<Pet> updateName(String name, Integer petId);

    Optional<Pet> updateSpecies(String species, Integer petId);

    Optional<Pet> updateRace(String race, Integer petId);

    Optional<Pet> updateSize(String size, Integer petId);

    Optional<Pet> updateSex(String sex, Integer petId);

    Optional<Pet> updatePicture(String picture, Integer petId);
}
