package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Visit")
public class Visit implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "visit_id", nullable = false)
    private Integer vistId;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vetId;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petId;

    public Visit(Integer vistId, String created_at, String type, String description, Vet vetId, Pet petId) {
        this.vistId = vistId;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.vetId = vetId;
        this.petId = petId;
    }

    public Visit() {
    }

    public Visit(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public Integer getVistId() {
        return vistId;
    }

    public void setVistId(Integer vistId) {
        this.vistId = vistId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVetId() {
        return vetId;
    }

    public void setVetId(Vet vetId) {
        this.vetId = vetId;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }
}
