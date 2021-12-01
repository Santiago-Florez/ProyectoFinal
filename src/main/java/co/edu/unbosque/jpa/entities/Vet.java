package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Vet")
@PrimaryKeyJoinColumn
public class Vet extends UserApp implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "vet_id", cascade = CascadeType.ALL)
    private List<Visit> visits;


    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "VET");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Vet() {}

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet_id(this);
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
}
