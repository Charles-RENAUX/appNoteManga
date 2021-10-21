package jee.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends GenericEntity{
    private String text;
    private long autorId;
    private Integer note;
    private Long likee;
    private Long dislike;

    @ManyToOne
    private Manga manga;

    public Review(String text, long autorId) {
        this.text = text;
        this.autorId = autorId;
    }

    public Review() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Long getLike() {
        return likee;
    }

    public void setLike(Long like) {
        this.likee = like;
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

    public long getAutorId() {
        return autorId;
    }

    public void setAutorId(long autorId) {
        this.autorId = autorId;
    }
}
