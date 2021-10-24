package jee.web.utils;

import jee.core.entity.Users;

public class CurrentUser {
    private static Users user;
    private static CurrentUser currentInstance;

    public CurrentUser(){

    }

    public static CurrentUser getInstance(){
        if (currentInstance==null){
            currentInstance = new CurrentUser();
            user = null;
        }
        return currentInstance;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser(){
        return (this.user);
    }

    public boolean isConnected(){
        if (user==null)
            return false;
        else
            return true;
    }

    public void logOff(){
        user=null;
    }
}
