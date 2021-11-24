package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.PetCase;
import co.edu.unbosque.jpa.repositories.PetCaseImpl;
import co.edu.unbosque.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.services.pojo.PetCasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;

    public PetCasePOJO save(Integer caseId, String createdAt, String type, String description, Integer petId){
        if (!type.equals("perdida") || !type.equals("robo") || !type.equals("fallecimiento")){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            petCaseRepository = new PetCaseImpl(entityManager);
            PetCase petCase = new PetCase(createdAt,type,description);
            petCaseRepository.saveType(petCase);

            entityManager.close();
            entityManagerFactory.close();

            PetCasePOJO petCasePOJO = new PetCasePOJO(createdAt,type,description);

            return petCasePOJO;
        }else{
            return null;
        }
    }

    public List<PetCasePOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseImpl(entityManager);
        List<PetCase> getCase = petCaseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePOJO> petCasePOJOS = new ArrayList<>();
        for(PetCase petCase : getCase){
            petCasePOJOS.add(new PetCasePOJO(petCase.getCaseId(),petCase.getCreated_at(),petCase.getType(),petCase.getDescription(), petCase.getPetId().getPetId()));
        }

        return petCasePOJOS;
    }
}
