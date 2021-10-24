package jee.web.dto;

import java.util.Date;

public class UsersDTO {

    private String pseudo;
    private String password;

    public UsersDTO(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }

    public UsersDTO() {
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
}
