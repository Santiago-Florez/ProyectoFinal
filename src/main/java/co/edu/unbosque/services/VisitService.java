package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Visit;
import co.edu.unbosque.jpa.repositories.VisitImpl;
import co.edu.unbosque.jpa.repositories.VisitRepository;
import co.edu.unbosque.services.pojo.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VisitService {

    VisitRepository visitRepository;
    private EntityManager entityManager;

    public VisitPOJO save(Integer visitId, String createdAt, String type, String description, String vetId, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        Visit visit = new Visit(createdAt, type, description);
        visitRepository.save(visit);

        entityManager.close();
        entityManagerFactory.close();

        VisitPOJO visitPOJO = new VisitPOJO(createdAt, type, description);

        return visitPOJO;
    }

    public List<VisitPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        List<Visit> getVisits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJOS = new ArrayList<>();
        for (Visit visit: getVisits){
            visitPOJOS.add(new VisitPOJO(visit.getVistId(), visit.getCreated_at(), visit.getType(), visit.getDescription(), visit.getVetId().getName(), visit.getPetId().getPetId()));
        }
        return visitPOJOS;
    }

    public VisitPOJO updatemicrochip(String micro, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        visitRepository.updatePetMicrochip(micro,petId);

        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        VisitPOJO visitPOJO = new VisitPOJO();

        for (Visit visit : visits){
            if (visit.getPetId().getPetId() == petId){
                visitPOJO = new VisitPOJO(visit.getVistId(), visit.getCreated_at(), visit.getType(), visit.getDescription(), visit.getVetId().getName(), visit.getPetId().getPetId());
            }
        }

        return visitPOJO;
    }
}
