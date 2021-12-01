package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable{

    @Id
    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "microchip")
    private String microChip;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "race")
    private String race;

    @Column(name = "size")
    private String size;

    @Column(name = "sex")
    private String sex;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "person_id")
    private Owner ownerId;

    @OneToMany(mappedBy = "pet_id", cascade = CascadeType.ALL)
    private List<Visit> visit = new ArrayList<>();

    @OneToMany(mappedBy = "pet_id", cascade = CascadeType.MERGE)
    private List<PetCase> petCase = new ArrayList<>();

    public Pet(Integer petId, String microChip, String name, String species, String race, String size, String sex, String picture) {
        this.petId = petId;
        this.microChip = microChip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Pet() {

    }

    public void addPetCase(PetCase petcases) {
        petCase.add(petcases);
        petcases.setPetId(this);
    }

    public void addVisit(Visit visits) {
        visit.add(visits);
        visits.setPet_id(this);
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getMicroChip() {
        return microChip;
    }

    public void setMicroChip(String microChip) {
        this.microChip = microChip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner() {
        return ownerId;
    }

    public void setOwner(Owner owner) {
        this.ownerId = owner;
    }

    public List<Visit> getVisit() {
        return visit;
    }

    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }

    public List<PetCase> getPetCase() {
        return petCase;
    }

    public void setPetCase(List<PetCase> petCase) {
        this.petCase = petCase;
    }
}
