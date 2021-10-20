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

    public Collection(String name) {
        this.name = name;
    }

    public Collection() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Manga> getMangaList() {
        return mangaList;
    }

    public void setMangaList(List<Manga> mangaList) {
        this.mangaList = mangaList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
