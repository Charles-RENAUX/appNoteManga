package jee.web.dto;

import java.util.Date;

public class UsersDTO {
    private String name;
    private String firstname;
    private String pseudo;
    private String password;
    private Boolean adminn;
    public long id;
    public Date creationDate;
    public Date updateDate;

    public UsersDTO() {
    }

    public UsersDTO(String name, String firstname, String pseudo, String password, Boolean adminn, long id, Date creationDate, Date updateDate) {
        this.name = name;
        this.firstname = firstname;
        this.pseudo = pseudo;
        this.password = password;
        this.adminn = adminn;
        this.id = id;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdminn() {
        return adminn;
    }

    public void setAdminn(Boolean adminn) {
        this.adminn = adminn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
