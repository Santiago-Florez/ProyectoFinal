package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> create(Official off);

    List<Official> findAll();

    Optional<Official> updateName(String name, String username);

}
