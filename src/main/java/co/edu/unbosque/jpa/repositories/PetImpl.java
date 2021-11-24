package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetImpl implements PetRepository{

    private EntityManager entityManager;

    public PetImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Pet> save(Pet pet) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pet> findAll() {
        return null;
    }

    @Override
    public Optional<Pet> updateName(String name, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.name = :name WHERE p.petId = :petId")
                .setParameter("name", name).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updateSpecies(String species, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.species = :species WHERE p.petId = :petId")
                .setParameter("species", species).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updateRace(String race, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.race = :race WHERE p.petId = :petId")
                .setParameter("race", race).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updateSize(String size, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.size = :size WHERE p.petId = :petId")
                .setParameter("size", size).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updateSex(String sex, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.sex = :sex WHERE p.petId = :petId")
                .setParameter("sex", sex).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updatePicture(String picture, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.picture = :picture WHERE p.petId = :petId")
                .setParameter("picture", picture).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }
}
