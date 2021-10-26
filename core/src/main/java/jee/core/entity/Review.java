package jee.core.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review extends GenericEntity{
    private String text;
    private Integer note;

    @ManyToOne
    @JoinColumn(name="authorId", nullable=false)
    private Users user;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="idManga", nullable=false)
    private Manga manga;

    public Review(String text, long authorId, Manga manga, Users user) {
        this.text = text;
        this.user  = user;
        this.manga = manga;
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

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public long getUserId(){
        return this.user.getId();
    }
}
