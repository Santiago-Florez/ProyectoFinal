package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.UserApp;
import co.edu.unbosque.jpa.repositories.UserAppImpl;
import co.edu.unbosque.jpa.repositories.UserAppRepository;
import co.edu.unbosque.services.pojo.UserAppPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;

    public UserAppPOJO saveUser(String username, String password, String email, String role){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppImpl(entityManager);
        UserApp userApp = new UserApp(username, password, email, role);
        userAppRepository.save(userApp);

        entityManager.close();
        entityManagerFactory.close();

        UserAppPOJO userAppPOJO = new UserAppPOJO(username,password,email,role);

        return userAppPOJO;
    }

    public List<UserAppPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppImpl(entityManager);
        List<UserApp> getusers = userAppRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserAppPOJO> usersPOJO = new ArrayList<>();
        for(UserApp user: getusers){
            usersPOJO.add(new UserAppPOJO(user.getUsername(),user.getPassword(),user.getEmail(),user.getRole()));
        }

        return usersPOJO;
    }

    public UserAppPOJO updateUser(String name, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppImpl(entityManager);
        userAppRepository.updateUser(name, username);

        List<UserApp> users = userAppRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        UserAppPOJO userAppPOJO = new UserAppPOJO();

        for (UserApp user : users){
            if (user.getUsername().equals(username)){
                userAppPOJO = new UserAppPOJO(user.getUsername(),user.getPassword(), user.getEmail(),user.getRole());
            }
        }

        return userAppPOJO;
    }
}
