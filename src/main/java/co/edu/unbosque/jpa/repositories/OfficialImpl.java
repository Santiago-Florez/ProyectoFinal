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
    public Optional<Official> updateName(String name, String username) {
        Official off = (Official) entityManager.createQuery("UPDATE Official o SET o.name = :name WHERE o.username = :username")
                .setParameter("name", name).setParameter("username", username).getSingleResult();
        return off != null ? Optional.of(off) : Optional.empty();
    }
}
