package java.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review extends GenericEntity{
    private String text;
    private String autor;
    private Integer note;
    private Long like;
    private Long dislike;

    @ManyToOne
    private Manga manga;


}
