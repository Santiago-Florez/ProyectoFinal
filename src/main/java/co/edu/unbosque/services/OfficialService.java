package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.*;
import co.edu.unbosque.jpa.repositories.OfficialImpl;
import co.edu.unbosque.jpa.repositories.OfficialRepository;
import co.edu.unbosque.resource.pojo.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public Optional<OfficialPOJO> createOfficial(OfficialPOJO officialPOJO){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        Official official = new Official(officialPOJO.getUsername(),officialPOJO.getPassword(), officialPOJO.getEmail(), officialPOJO.getName(), officialPOJO.getPersonId());
        Optional<Official> persistedOfficial = officialRepository.create(official);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOfficial.isPresent()){
            return Optional.of(new OfficialPOJO(persistedOfficial.get().getUsername(),
                    persistedOfficial.get().getPassword(),
                    persistedOfficial.get().getEmail(),
                    persistedOfficial.get().getName(),persistedOfficial.get().getPersonId()));
        }else{
            return Optional.empty();
        }
    }

    public Official findUsername(String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        Official persistedOwner = officialRepository.findByOwnerId(username).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    public List<OwnerPOJO> findOwnerLocalidad(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Owner> persistedOwner = officialRepository.findOwnerLocalidad();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownerPOJOS = new ArrayList<>();
        for (Owner owner: persistedOwner){
            ownerPOJOS.add(new OwnerPOJO(owner.getUsername(),
                    owner.getPassword(),
                    owner.getEmail(),
                    owner.getPersonId(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()));
        }

        return ownerPOJOS;
    }

    public List<PetPOJO> findBySpecie(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Pet> pets = officialRepository.findPetBySpecies();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOS = new ArrayList<>();

        for (Pet pet: pets){
            petPOJOS.add(new PetPOJO( pet.getPetId(),pet.getMicroChip(),pet.getName(),pet.getSpecies(), pet.getRace(), pet.getSize(),
                    pet.getSex(),pet.getPicture(), pet.getOwner().getPersonId()));
        }

        return petPOJOS;
    }

    public List<PetPOJO> findPetByStatusMicrochip(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Pet> pets = officialRepository.findPetByStatusMicrochip();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOS = new ArrayList<>();

        for (Pet pet: pets){
            petPOJOS.add(new PetPOJO( pet.getPetId(),pet.getMicroChip(),pet.getName(),pet.getSpecies(), pet.getRace(), pet.getSize(),
                    pet.getSex(),pet.getPicture(), pet.getOwner().getPersonId()));
        }

        return petPOJOS;
    }

    public List<VisitPOJO> findPetByStatusSterilization(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Visit> visits = officialRepository.findPetByStatusSterilization();

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

    public List<PetCasePOJO> findCaseByType(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<PetCase> petCases = officialRepository.findCaseByType();

        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePOJO> petCasePOJOS = new ArrayList<>();
        for (PetCase petCase: petCases){
            petCasePOJOS.add(new PetCasePOJO(petCase.getCaseId(),petCase.getCreated_at(),petCase.getType(),petCase.getDescription(), petCase.getPetId().getPetId()));
        }

        return petCasePOJOS;
    }

    public List<VisitPOJO> findByVetName(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Visit> visits = officialRepository.findByVetName();

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

    public List<VisitPOJO> findVisitByType(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Visit> visits = officialRepository.findVisitByType();

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

    public OfficialPOJO updateName(String newName, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        officialRepository.updateName(newName, username);

        entityManager.close();
        entityManagerFactory.close();

        Official official = findUsername(username);
        OfficialPOJO officialPOJO = new OfficialPOJO(official.getUsername(),
                official.getPassword(),
                official.getEmail(),
                official.getName(), official.getPersonId());

        return officialPOJO;
    }

    public OfficialPOJO updateEmail(String newEmail, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        officialRepository.updateEmail(newEmail, username);

        entityManager.close();
        entityManagerFactory.close();

        Official offi = findUsername(username);
        OfficialPOJO ownerPOJO = new OfficialPOJO(offi.getUsername(),
                offi.getPassword(),
                offi.getEmail(),
                offi.getName(), offi.getPersonId());

        return ownerPOJO;
    }
}
