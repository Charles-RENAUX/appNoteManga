package jee.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class User extends GenericEntity {
    private String name;
    private String firstname;
    private String adress;
    private String pseudo;
    private String password;
    private Boolean adminn;

    //@ManyToMany(mappedBy = "user")
    //private List<Collection> collectionList;

    public User(String name, String firstname, String adress, String pseudo, String password) {
        this.name = name;
        this.firstname = firstname;
        this.adress = adress;
        this.pseudo = pseudo;
        this.password = password;
        this.adminn = false;
    }

    public User() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    /*public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }*/
}
