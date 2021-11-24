package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetImpl implements VetRepository{

    private EntityManager entityManager;

    public VetImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Vet> save(Vet vet) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet ").getResultList();
    }

    @Override
    public Optional<Vet> updateName(String name, String username) {
        Vet vet = (Vet) entityManager.createQuery("UPDATE Vet vet SET vet.name = :name WHERE vet.username = :username")
                .setParameter("name",name).getSingleResult();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> updateAddress(String address, String username) {
        Vet vet = (Vet) entityManager.createQuery("UPDATE Vet vet SET vet.address = :address WHERE vet.username = :username")
                .setParameter("address",address).getSingleResult();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> updateNeighborhood(String neighborhood, String username) {
        Vet vet = (Vet) entityManager.createQuery("UPDATE Vet vet SET vet.neighborhood = :neighborhood WHERE vet.username = :username")
                .setParameter("neighborhood", neighborhood).getSingleResult();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }
}
