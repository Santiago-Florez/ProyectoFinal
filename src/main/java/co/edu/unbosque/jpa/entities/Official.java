package co.edu.unbosque.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
public class Official extends UserApp implements Serializable{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "person_id", unique = true)
    private Long personId;

    public Official(String username, String password, String email, String name, Long personId) {
        super(username, password, email, "official");
        this.name = name;
        this.personId = personId;
    }

    public Official() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
