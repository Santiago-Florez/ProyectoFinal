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
    public Optional<Vet> findByVetId(Integer vetId) {
        Vet pet = entityManager.createQuery("SELECT o FROM Vet o WHERE o.vetid = :vetId", Vet.class)
                .setParameter("vetId", vetId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Vet> findByUsername(String name) {
        Vet pet = entityManager.createQuery("SELECT o FROM Vet o WHERE o.username = :name", Vet.class)
                .setParameter("name", name).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Vet> updateName(String name, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> updateAddress(String address, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setAddress(address);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> updateNeighborhood(String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> updateAddressAndNeighborhood(String address, String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setAddress(address);
            vet.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
