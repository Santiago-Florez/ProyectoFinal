package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.repositories.PetImpl;
import co.edu.unbosque.jpa.repositories.PetRepository;
import co.edu.unbosque.services.pojo.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PetService {

    PetRepository petRepository;

    public PetPOJO save(String microchip, String name, String species, String race, String size, String sex, String picture){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        Pet pet = new Pet(microchip, name, species, race, size, sex, picture);
        petRepository.save(pet);

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO(microchip, name, species, race, size, sex, picture);

        return petPOJO;
    }

    public List<PetPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        List<Pet> getPets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOS = new ArrayList<>();
        for (Pet pet : getPets){
            petPOJOS.add(new PetPOJO(pet.getPetId(),pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), pet.getOwner().getPerson_id()));
        }

        return petPOJOS;
    }

    public PetPOJO updateNames(String name, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateName(name, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }

    public PetPOJO updateSpecie(String species, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSpecies(species, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }

    public PetPOJO updateRaces(String race, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateRace(race, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }

    public PetPOJO updateSizes(String size, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSize(size, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }

    public PetPOJO updateSexs(String sex, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSex(sex, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }

    public PetPOJO updatePictures(String picture, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updatePicture(picture, petId);

        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO();

        for (Pet pet : pets){
            if (pet.getPetId().equals(petId)){
                petPOJO = new PetPOJO(pet.getMicroChip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture());
            }
        }

        return petPOJO;
    }
}
