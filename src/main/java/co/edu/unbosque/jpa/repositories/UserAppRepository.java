package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> save(UserApp usApp);
    List<UserApp> findAll();
    Optional<UserApp> updateUser(String email, String username);
    Optional<UserApp> findByUsername(String name);
}
