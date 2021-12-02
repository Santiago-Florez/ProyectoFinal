package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> create(Owner ow);

    List<Owner> findAll();
    Optional<Owner> findByOwnerId(String ownerId);

    Optional<Owner> updateName(String name, String username);

    Optional<Owner> updateAddress(String address, String username);

    Optional<Owner> updateNeighborhood(String neighborhood, String username);

    Optional<Owner> updateEmail(String email, String username);

    Optional<Owner> updatePassword(String newPassword, String userName);

    Optional<Owner> updatePasswordEmail(String newPassword, String newEmail, String userName);

    Optional<Owner> updateAddressAndNeighborhood(String address,String neighborhood, String username);
}
