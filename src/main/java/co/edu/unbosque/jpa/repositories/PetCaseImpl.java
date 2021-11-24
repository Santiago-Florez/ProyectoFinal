package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetCaseImpl implements PetCaseRepository{

    private EntityManager entityManager;

    public PetCaseImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<PetCase> saveType(PetCase pet) {
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
    public List<PetCase> findAll() {
        return entityManager.createQuery("from PetCase ").getResultList();
    }
}
