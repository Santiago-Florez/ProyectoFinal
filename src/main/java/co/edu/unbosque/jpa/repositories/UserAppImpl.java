package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserAppImpl implements UserAppRepository{

    private EntityManager entityManager;

    public UserAppImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserApp> save(UserApp user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<UserApp> findAll() {
        return entityManager.createQuery("from UserApp ").getResultList();
    }

    @Override
    public Optional<UserApp> updateUser(String email, String username) {
        UserApp user = (UserApp) entityManager.createQuery("UPDATE UserApp u  SET u.email = : email WHERE u.username = :username")
                .setParameter("email", email).setParameter("username", username).getSingleResult();
        return user != null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public Optional<UserApp> findByUsername(String username) {
        UserApp userApp = entityManager.find(UserApp.class,username);
        return userApp!=null ? Optional.of(userApp) : Optional.empty();
    }
}
