package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PetCase")
public class PetCase implements Serializable{

    @Id
    @Column(name = "case_id")
    private Integer caseId;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id", unique = true)
    private Pet pet_id;

    public PetCase(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public PetCase(Integer caseId, String created_at, String type, String description) {
        this.caseId = caseId;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public PetCase() {}

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
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

    public Pet getPetId() {
        return pet_id;
    }

    public void setPetId(Pet petId) {
        this.pet_id = petId;
    }
}
