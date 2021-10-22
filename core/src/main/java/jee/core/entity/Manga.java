package jee.core.entity;



import javax.persistence.Entity;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Manga extends GenericEntity{

    private String name;
    private String resume;
    private Float note;
    private String image;

    @OneToMany(targetEntity = Review.class, mappedBy="manga")
    private List<Review> reviewList;

    public Manga(String name, String resume) {
        this.name = name;
        this.resume = resume;
    }

    public Manga() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Float getNote() {
        float _note = 0;
        for (Review review : this.reviewList){
            _note += review.getNote();
        }
        _note = _note/(this.reviewList.size());
        if (this.note != _note)
            this.note = _note;
        return this.note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

}
