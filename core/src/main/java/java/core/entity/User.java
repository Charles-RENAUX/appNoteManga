package java.core.entity;

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
    private Boolean admin;

    @ManyToMany(mappedBy = "user")
    private List<Collection> collectionList;


}
