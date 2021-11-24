package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Visit")
public class Visit implements Serializable{

    @Id
    @Column(name = "visit_id", nullable = false)
    private String visit_id;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet_id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

    public Visit(String visit_id, String created_at, String type, String description) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public Visit() {}

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vet getVet_id() {
        return vet_id;
    }

    public void setVet_id(Vet vet_id) {
        this.vet_id = vet_id;
    }

    public Pet getPet_id() {
        return pet_id;
    }

    public void setPet_id(Pet pet_id) {
        this.pet_id = pet_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
