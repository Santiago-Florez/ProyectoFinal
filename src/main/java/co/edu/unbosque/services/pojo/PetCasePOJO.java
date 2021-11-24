package co.edu.unbosque.services.pojo;

public class PetCasePOJO {

    private Integer caseId;
    private String createdAt;
    private String type;
    private String description;
    private Integer petId;

    public PetCasePOJO(){}

    public PetCasePOJO(Integer caseId, String createdAt, String type, String description, Integer petId) {
        this.caseId = caseId;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.petId = petId;
    }

    public PetCasePOJO(String createdAt, String type, String description) {
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }
}
