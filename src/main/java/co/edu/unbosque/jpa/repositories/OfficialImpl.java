package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Official;

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
    public Optional<Official> findByOwnerId(String officialId) {
        Official of = entityManager.createQuery("SELECT o FROM Official o WHERE o.username = :officialId", Official.class)
                .setParameter("officialId", officialId).getSingleResult();
        return of != null ? Optional.of(of) : Optional.empty();
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
}
