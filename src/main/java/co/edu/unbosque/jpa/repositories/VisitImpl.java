package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Pet;
import co.edu.unbosque.workshop5.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> save(Visit visit) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        }catch(Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }

    @Override
    public Optional<Pet> updatePetMicrochip(String microchip, Integer petId) {
        Pet pet = (Pet) entityManager.createQuery("UPDATE Pet p SET p.microChip = :microchip WHERE p.petId = :petId")
                .setParameter("petId", petId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }
}
