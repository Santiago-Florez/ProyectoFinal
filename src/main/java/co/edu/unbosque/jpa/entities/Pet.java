package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pet_id", nullable = false)
    private Integer petId;

    @Column(name = "microchip", nullable = false, unique = true)
    private String microChip;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "picture" , nullable = false)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "person_id")
    private Owner owner;

    @OneToMany(mappedBy = "petId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visit = new ArrayList<>();

    @OneToMany(mappedBy = "petId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PetCase> petCase = new ArrayList<>();

    public Pet(String microChip, String name, String species, String race, String size, String sex, String picture) {
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
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
