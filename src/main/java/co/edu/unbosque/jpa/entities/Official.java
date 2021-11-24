package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Official")
public class Official implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userApp;

    //pruebaaaaaaaaaaa

    @Column(name = "name", nullable = false)
    private String name;

    public Official( String name) {
        this.name = name;
    }

    public Official() {
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp username) {
        this.userApp = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
