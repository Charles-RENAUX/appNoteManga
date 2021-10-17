package java.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review extends GenericEntity{
    private String text;
    private long Idautor;
    private Integer note;
    private Long like;
    private Long dislike;

    @ManyToOne
    private Manga manga;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIdautor() {
        return Idautor;
    }

    public void setIdautor(long idautor) {
        Idautor = idautor;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getDislike() {
        return dislike;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }
}
