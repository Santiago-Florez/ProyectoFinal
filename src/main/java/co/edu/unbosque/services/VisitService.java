package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.entities.Vet;
import co.edu.unbosque.jpa.entities.Visit;
import co.edu.unbosque.jpa.repositories.*;
import co.edu.unbosque.resource.pojo.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class VisitService {

    VisitRepository visitRepository;
    VetRepository userAppRepository;
    PetRepository petRepository;

    public VisitPOJO createVisit(String visitId, String createdAt, String type, String description, String vetId, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        userAppRepository = new VetImpl(entityManager);
        petRepository = new PetImpl(entityManager);
        Optional<Pet> pet = petRepository.findId(petId);
        Optional<Vet> userApp = userAppRepository.findByUsername(vetId);

        pet.ifPresent(pet1 -> {
            Visit visit = new Visit(visitId, createdAt, type, description);
            visit.setPet_id(pet1);
            pet1.addVisit(visit);
            visitRepository.save(visit);
        });
        userApp.ifPresent(userApp1 -> {
            Visit visit = new Visit(visitId, createdAt, type, description);
            visit.setVet_id(userApp1);
            userApp1.addVisit(visit);
            visitRepository.save(visit);
        });

        entityManager.close();
        entityManagerFactory.close();

        VisitPOJO visitPOJO = new VisitPOJO(visitId,createdAt, type, description);

        return visitPOJO;
    }

    public Pet findPetId(Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        Pet persistedPet = petRepository.findId(petId).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;
    }

    public List<VisitPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJOS = new ArrayList<>();
        for (Visit visit: visits){
            visitPOJOS.add(new VisitPOJO(visit.getVisit_id(), visit.getCreated_at(),
                    visit.getType(), visit.getDescription(),
                    visit.getVet_id().getUsername(), visit.getPet_id().getPetId()));
        }

        return visitPOJOS;
    }
}
