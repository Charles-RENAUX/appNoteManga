package java.core.entity;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Manga extends GenericEntity{

    private String name;
    private String editor;
    private String resume;
    private Float note;
    private String image;

    @ElementCollection
    private List<String> chapterList;

    @ManyToOne
    private Review review;

    @ManyToMany(mappedBy = "manga")
    private List<Collection> collectionList;

}
