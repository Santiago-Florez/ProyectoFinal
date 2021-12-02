package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    List<Vet> findAll();

    Optional<Vet> findByVetId(Integer vetId);

    Optional<Vet> findByUsername(String name);

    Optional<Vet> updateName(String name, String username);

    Optional<Vet> updateAddress(String address, String username);

    Optional<Vet> updateNeighborhood(String neighborhood, String username);

    Optional<Vet> updateAddressAndNeighborhood(String address,String neighborhood, String username);

    Optional<Vet> updateEmail(String email, String username);

    Optional<Vet> updatePassword(String newPassword, String userName);

    Optional<Vet> updatePasswordEmail(String newPassword, String newEmail, String userName);
}
