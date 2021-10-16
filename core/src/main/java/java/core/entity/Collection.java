package java.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Collection extends GenericEntity{
    private String name;

    @ManyToMany(mappedBy = "collection")
    private List<Manga> mangaList;

    @ManyToMany(mappedBy="collection")
    private List<User> userList;

}
