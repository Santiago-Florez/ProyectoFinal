package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vet")
public class Vet implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private UserApp username;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "vetId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visit = new ArrayList<>();

    public Vet(){}

    public Vet(String name, String address, String neighborhood) {
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public UserApp getUsername() {
        return username;
    }

    public void setUsername(UserApp username) {
        this.username = username;
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

    public List<Visit> getVisit() {
        return visit;
    }

    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }
}
