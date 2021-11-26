package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.repositories.OwnerImpl;
import co.edu.unbosque.jpa.repositories.OwnerRepository;
import co.edu.unbosque.jpa.repositories.PetImpl;
import co.edu.unbosque.jpa.repositories.PetRepository;
import co.edu.unbosque.resource.pojo.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class PetService {

    PetRepository petRepository;
    OwnerRepository ownerRepository;

    public PetPOJO createdPet(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture, Integer ownerId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        ownerRepository = new OwnerImpl(entityManager);
        Optional<Owner> owner = Optional.of(ownerRepository.findAll().get(ownerId-1));
        owner.ifPresent(o->{
            o.addPet(new Pet(petId, microchip, name,species, race,size,sex, picture));
            ownerRepository.create(o);
        });

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO(petId,microchip,name,species,race,size,sex,picture,ownerId);
        return petPOJO;

    }

    public Pet findPetId(Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        Pet persistedPet = petRepository.findId(petId).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;
    }

    public Pet findOwnerId(Integer ownerId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        Pet persistedPet = petRepository.findOwnerId(ownerId).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;
    }

    public PetPOJO updateName(String newName, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateName(newName, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updateSpecies(String newSpecies, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSpecies(newSpecies, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updateRace(String newRace, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateRace(newRace, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updateSize(String newSize, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSize(newSize, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updateSex(String newSex, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSex(newSex, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updatePicture(String newPicture, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updatePicture(newPicture, petId);


        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    public PetPOJO updateMicrochip(String newMicrochip, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taller5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updatePetMicrochip(newMicrochip, petId);


        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }
}
