package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Vet;
import co.edu.unbosque.jpa.repositories.VetImpl;
import co.edu.unbosque.jpa.repositories.VetRepository;
import co.edu.unbosque.services.pojo.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VetService {

    VetRepository vetRepository;

    public VetPOJO save(String username, String name, String address, String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        Vet vet = new Vet(name, address, neighborhood);
        vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();

        VetPOJO vetPOJOS = new VetPOJO(name, address, neighborhood);

        return vetPOJOS;
    }

    public List<VetPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        List<Vet> getVets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetPOJO> vetPOJOS = new ArrayList<>();
        for (Vet vet: getVets){
            vetPOJOS.add(new VetPOJO(vet.getUsername().getUsername(),vet.getName(), vet.getAddress(), vet.getNeighborhood()));
        }

        return vetPOJOS;
    }

    public VetPOJO updateName(String name, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateName(name, username);

        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        VetPOJO vetPOJOS = new VetPOJO();

        for (Vet vet:vets){
            if(vet.getUsername().equals(username)){
                vetPOJOS = new VetPOJO(vet.getName(), vet.getAddress(), vet.getNeighborhood());
            }
        }

        return vetPOJOS;
    }

    public VetPOJO updateAddress(String address, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateAddress(address, username);

        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        VetPOJO vetPOJO = new VetPOJO();

        for (Vet vet:vets){
            if(vet.getUsername().equals(username)){
                vetPOJO = new VetPOJO(vet.getName(), vet.getAddress(), vet.getNeighborhood());
            }
        }

        return vetPOJO;
    }

    public VetPOJO updateneighborhood(String neighborhood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateNeighborhood(neighborhood, username);

        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        VetPOJO vetPOJO = new VetPOJO();

        for (Vet vet:vets){
            if(vet.getUsername().equals(username)){
                vetPOJO = new VetPOJO(vet.getName(), vet.getAddress(), vet.getNeighborhood());
            }
        }

        return vetPOJO;
    }
}
