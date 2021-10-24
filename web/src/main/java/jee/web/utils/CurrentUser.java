package jee.web.utils;

import jee.core.entity.Users;

public class CurrentUser {
    private Users user;
    private static CurrentUser currentInstance;

    public CurrentUser(){

    }

    public static CurrentUser getInstance(){
        if (currentInstance==null){
            new CurrentUser();
        }
        return currentInstance;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
