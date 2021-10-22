package jee.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Users extends GenericEntity {
    private String name;
    private String firstname;
    private String pseudo;
    private String password;
    private Boolean adminn;

    public Users(String name, String firstname, String pseudo, String password, boolean adminn) {
        this.name = name;
        this.firstname = firstname;
        this.pseudo = pseudo;
        this.password = password;
        this.adminn = adminn;
    }

    public Users() {
        this.adminn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return adminn;
    }

    public void setAdmin(Boolean admin) {
        this.adminn = admin;
    }

}
