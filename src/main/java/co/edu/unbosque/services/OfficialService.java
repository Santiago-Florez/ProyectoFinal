package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Official;
import co.edu.unbosque.jpa.repositories.OfficialImpl;
import co.edu.unbosque.jpa.repositories.OfficialRepository;
import co.edu.unbosque.resource.pojo.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
