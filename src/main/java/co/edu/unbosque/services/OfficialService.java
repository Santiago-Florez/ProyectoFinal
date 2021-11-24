package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Official;
import co.edu.unbosque.jpa.repositories.OfficialImpl;
import co.edu.unbosque.jpa.repositories.OfficialRepository;
import co.edu.unbosque.services.pojo.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public OfficialPOJO create(String username, String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        Official official = new Official(name);
        officialRepository.create(official);

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialPOJO = new OfficialPOJO(name);

        return officialPOJO;
    }

    public OfficialPOJO updateName(String name, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        officialRepository.updateName(name, username);

        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialPOJO = new OfficialPOJO();

        for (Official official: officials){
            if(official.getUserApp().equals(username)){
                officialPOJO = new OfficialPOJO(official.getName());
            }
        }
        return officialPOJO;
    }

    public List<OfficialPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Official> getofficials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPOJO> officialPOJOS = new ArrayList<>();
        for (Official official: getofficials){
            officialPOJOS.add(new OfficialPOJO(official.getUserApp().getUsername(), official.getName()));
        }

        return officialPOJOS;
    }
}
