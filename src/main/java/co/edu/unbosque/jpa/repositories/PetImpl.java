package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetImpl implements PetRepository {

    private final EntityManager entityManager;

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
    public Optional<Pet> findId(Integer id) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.petId = :id", Pet.class)
                .setParameter("id", id).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> findOwnerId(Integer ownerId) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.ownerId.personId = :ownerId", Pet.class)
                .setParameter("ownerId", ownerId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> updateName(String name, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updateSpecies(String species, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSpecies(species);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updateRace(String race, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setRace(race);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updateSize(String size, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSize(size);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updateSex(String sex, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSex(sex);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updatePicture(String picture, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setPicture(picture);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updatePetMicrochip(String microchip, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setMicroChip(microchip);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
