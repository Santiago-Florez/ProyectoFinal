package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OfficialImpl implements OfficialRepository{

    private EntityManager entityManager;

    public OfficialImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Official> create(Official off) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(off);
            entityManager.getTransaction().commit();
            return Optional.of(off);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Official> findAll() {
        return entityManager.createQuery("from Official ").getResultList();
    }

    @Override
    public Optional<Official> updateName(String name, String username) {
        try{
            entityManager.getTransaction().begin();
            Official official = entityManager.find(Official.class, username);
            official.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(official);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Official> updateEmail(String email, String username) {
        try{
            entityManager.getTransaction().begin();
            Official official = entityManager.find(Official.class, username);
            official.setEmail(email);
            entityManager.getTransaction().commit();

            return Optional.of(official);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Official> findByOwnerId(String officialId) {
        Official of = entityManager.createQuery("SELECT o FROM Official o WHERE o.username = :officialId", Official.class)
                .setParameter("officialId", officialId).getSingleResult();
        return of != null ? Optional.of(of) : Optional.empty();
    }

    @Override
    public List<Owner> findOwnerLocalidad(String localidad) {
        return entityManager.createQuery("SELECT ow FROM Owner ow WHERE ow.neighborhood = :localidad", Owner.class)
                .setParameter("localidad", localidad).getResultList();
    }

    @Override
    public List<Pet> findPetBySpecies(String specie) {
        return entityManager.createQuery("SELECT p FROM Pet p WHERE p.species = :specie", Pet.class)
                .setParameter("specie", specie).getResultList();
    }

    @Override
    public List<Pet> findPetByStatusMicrochip() {
        return entityManager.createQuery("from Pet", Pet.class).getResultList();
    }

    @Override
    public List<Visit> findPetByStatusSterilization(String sterilization) {
        return entityManager.createQuery("from Visit", Visit.class).getResultList();
    }

    @Override
    public List<PetCase> findCaseByType(String type) {
        return entityManager.createQuery("SELECT pc FROM PetCase pc WHERE pc.type = :type", PetCase.class)
                .setParameter("type", type).getResultList();
    }

    @Override
    public List<Visit> findByVetName(String vetName) {
        return entityManager.createQuery("SELECT v FROM Visit v WHERE v.vet_id.name = :vetName", Visit.class)
                .setParameter("vetName", vetName).getResultList();
    }

    @Override
    public List<Visit> findVisitByType(String type) {
        return entityManager.createQuery("SELECT v FROM Visit v WHERE v.type = :type", Visit.class)
                .setParameter("type", type).getResultList();
    }
}
