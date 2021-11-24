package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.repositories.OwnerImpl;
import co.edu.unbosque.jpa.repositories.OwnerRepository;
import co.edu.unbosque.services.pojo.OwnerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;

    public OwnerPOJO save(String name, String address, String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        Owner owner = new Owner(name, address, neighborhood);
        ownerRepository.create(owner);

        entityManager.close();
        entityManagerFactory.close();

        OwnerPOJO ownerPOJO = new OwnerPOJO(name, address, neighborhood);

        return ownerPOJO;
    }

    public List<OwnerPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        List<Owner> getOwners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownerPOJOS = new ArrayList<>();
        for (Owner owner: getOwners){
            ownerPOJOS.add(new OwnerPOJO(owner.getUsername().getUsername(), owner.getName(), owner.getAddress(), owner.getNeighborhood()));
        }

        return ownerPOJOS;
    }

    public OwnerPOJO updateName(String name, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateName(name, username);

        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        OwnerPOJO ownerPOJO = new OwnerPOJO();

        for (Owner owner:owners){
            if(owner.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(owner.getName(), owner.getAddress(), owner.getNeighborhood());
            }
        }

        return ownerPOJO;
    }

    public OwnerPOJO updateAddress(String address, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateAddress(address, username);

        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        OwnerPOJO ownerPOJO = new OwnerPOJO();

        for (Owner owner:owners){
            if(owner.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(owner.getName(), owner.getAddress(), owner.getNeighborhood());
            }
        }

        return ownerPOJO;
    }

    public OwnerPOJO updateneighborhood(String neighborhood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateNeighborhood(neighborhood, username);

        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        OwnerPOJO ownerPOJO = new OwnerPOJO();

        for (Owner owner:owners){
            if(owner.getUsername().equals(username)){
                ownerPOJO = new OwnerPOJO(owner.getName(), owner.getAddress(), owner.getNeighborhood());
            }
        }

        return ownerPOJO;
    }
}
