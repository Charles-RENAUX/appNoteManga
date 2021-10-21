package jee.core.entity;



import javax.persistence.Entity;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

    @OneToMany(targetEntity = Review.class, mappedBy="manga")
    private List<Review> reviewList;

    //@ManyToMany(mappedBy = "manga")
    //private List<Collection> collectionList;

    public Manga(String name, String editor, String resume) {
        this.name = name;
        this.editor = editor;
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public List<String> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<String> chapterList) {
        this.chapterList = chapterList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    /*public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }*/
}
