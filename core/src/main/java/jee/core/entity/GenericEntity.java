package jee.core.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public Date creationDate;

    public Date updateDate;


    public long getId() {
        return id;
    }


    @PrePersist
    public void addCreateDate() {
        creationDate = new Date();
    }


    @PreUpdate
    public void addUpdateDate() {
        updateDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}