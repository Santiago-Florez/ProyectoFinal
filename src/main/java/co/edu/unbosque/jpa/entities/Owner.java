package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "username" )
    private UserApp username;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", unique = true, nullable = false)
    private Integer person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner(String name, String address, String neighborhood) {
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Owner() {
    }
    public UserApp getUsername() {
        return username;
    }

    public void setUsername(UserApp username) {
        this.username = username;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


}
