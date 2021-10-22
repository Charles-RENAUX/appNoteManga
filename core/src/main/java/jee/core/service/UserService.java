package jee.core.service;

import jee.core.dao.MangaDAO;
import jee.core.dao.ReviewDAO;
import jee.core.dao.UserDAO;
import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.entity.Users;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@Service
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

    public List<Manga> getUsersManga(long userId){
        List<Manga> res =  new ArrayList<Manga>();
        for (Review review : reviewDAO.findAll()){
            if (review.getUser().getId()==userId){
                res.add(review.getManga());
            }
        }
        return res;
    }

    public void createUser(String name, String firstName, String pseudo, String password, boolean admin){
        userDAO.save(new Users(name,firstName,pseudo,password,admin));
    }

    public Users findUser(long userId){
        return userDAO.getById(userId);
    }
}
