package java.core.entity;


import javax.persistence.*;
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

    @OneToMany(targetEntity = Review.class, mappedBy="Manga")
    private List<Review> reviewList;

    @ManyToMany(mappedBy = "manga")
    private List<Collection> collectionList;

}
