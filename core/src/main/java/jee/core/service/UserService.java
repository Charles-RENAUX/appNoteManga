package jee.core.service;

import jee.core.dao.MangaDAO;
import jee.core.dao.ReviewDAO;
import jee.core.dao.UserDAO;
import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.entity.Users;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
@Service
@Transactional
public class UserService {

    private UserDAO userDAO;
    private ReviewDAO reviewDAO;

    public UserService(UserDAO userDAO, ReviewDAO reviewDAO){
        this.userDAO = userDAO;
        this.reviewDAO = reviewDAO;
    }

    public boolean canUserConnect(String pseudo, String mdp){
        List<Users> users = userDAO.findAll();
        for(Users user : users){
            if (user.getPseudo().equals(pseudo) && user.getPassword().equals(mdp)){
                return true;
            }
        }
        return false;
    }

    public Users findUserByConnexion(String pseudo, String mdp){
        List<Users> users = userDAO.findAll();
        for(Users user : users){
            if (user.getPseudo().equals(pseudo) && user.getPassword().equals(mdp)){
                return user;
            }
        }
        return null;
    }

    public List<Manga> getUsersManga(long userId){
        List<Manga> res =  new ArrayList<Manga>();
        for (Review review : reviewDAO.findAll()){
            if (review.getUser().getId()==userId){
                res.add(review.getManga());
            }
        }
        return res;
    }

    public void createUser(String name, String firstName, String pseudo, String password, String adress, boolean admin){
        userDAO.save(new Users(name,firstName,pseudo,password,adress,admin));
    }

    public Users findUser(long userId){
        Users user = userDAO.findAll().stream().filter(users -> userId==users.getId())
                .findAny()
                .orElse(null);
        return user;
    }

    public void addUser(Users user){
        userDAO.save(user);
    }

    public boolean doesUserPseudoAlreadyExist(Users user){
        if (userDAO.findAll().stream().filter(users -> user.getPseudo().equals(users.getPseudo()))
                .findAny()
                .orElse(null)==null){
            return false;
        }else{
            return true;
        }
    }

    public Users updateUser(Users user){
        Users old = null;
        for(Users userr : userDAO.findAll()){
            if (user.getId()==userr.getId()){
                old = userr;
            }
        }
        userDAO.delete(old);
        addUser(user);
        for(Users userr : userDAO.findAll()){
            if (user.getPseudo().equals(userr.getPseudo())){
                return userr;
            }
        }
        return null;
    }
}
