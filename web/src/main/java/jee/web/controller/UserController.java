package jee.web.controller;

import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.entity.Users;
import jee.core.service.MangaService;
import jee.core.service.UserService;
import jee.web.utils.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Named
@Controller
public class UserController{

    private UserService userService;
    private MangaService mangaService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, MangaService mangaService){
        this.userService=userService;
        this.mangaService = mangaService;
    }

    @GetMapping("/login")
    public String getLoginPage(ModelMap map){
        return "login";
    }

    @GetMapping("/user/registration/fill")
    private String openRegistration(ModelMap map){
        map.addAttribute("user",new Users());
        map.addAttribute("pseudoDouble", false);
        return "registration";
    }

    @RequestMapping(value = "/user/registration/form", method = RequestMethod.POST)
    private String submitForm(@ModelAttribute("user") Users user, ModelMap map){

        logger.info("Trying to create new user: "+user.getPseudo());

        if(userService.doesUserPseudoAlreadyExist(user)){
            logger.info("Error, pseudo already exist");
            map.addAttribute("pseudoDouble", true);
            return "redirect:http://localhost:8080/user/registration/fill";
        }else
        {
            logger.info("Success, user added and connected");
            userService.addUser(user);
            CurrentUser.getInstance().setUser(user);
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/userPage/fill")
    private String getUserPage(ModelMap map){
        if(CurrentUser.getInstance().isConnected()) {
            if(CurrentUser.getInstance().getUser().getAdmin() == true){
                map.addAttribute("listUsers", userService.getAllUsers());
                map.addAttribute("listManga", mangaService.getAllMangas());
            }
            map.addAttribute("user", CurrentUser.getInstance().getUser());
            return "UserPge";
        }else{
            logger.warn("Anonymous user trying to access user page");
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/logOff")
    private String logOffCurrentUser(ModelMap map){
        logger.info("User "+CurrentUser.getInstance().getUser().getPseudo()+" log off");
        CurrentUser.getInstance().logOff();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/userPage/form", method = RequestMethod.POST)
    private String modifyUser(@ModelAttribute("user") Users user, ModelMap map) throws InterruptedException {
        if(CurrentUser.getInstance().isConnected()) {
            logger.info("User "+CurrentUser.getInstance().getUser()+" modified his/her info");
            user.setId(CurrentUser.getInstance().getUser().getId());
            userService.addUser(user);
            Users newU = userService.findUser(user.getId());
            CurrentUser.getInstance().logOff();
            CurrentUser.getInstance().setUser(newU);
            return "redirect:http://localhost:8080/userPage/fill";
        }else{
            logger.warn("Anonymous user trying to send modified user form");
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/permission/addAdmin/{id}")
    public String changeUserAdmin(@PathVariable("id") long userId){
        Users toModif = userService.findUser(userId);
        if(CurrentUser.getInstance().getUser().getAdmin()){
            toModif.setAdmin(true);
            userService.addUser(toModif);
            logger.info("Admin "+CurrentUser.getInstance().getUser().getPseudo()+" add as admin user "+toModif.getPseudo());
            return "redirect:http://localhost:8080/userPage/fill";

        }else{
            if(CurrentUser.getInstance().isConnected())
                logger.warn("User "+CurrentUser.getInstance().getUser().getPseudo()+" is trying to add as admin "+toModif.getPseudo());
            else
                logger.warn("Anonymous user is trying to add as admin "+toModif.getPseudo());
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/permission/rmAdmin/{id}")
    public String changeUserNotAdmin(@PathVariable("id") long userId){
        Users toModif = userService.findUser(userId);
        if(CurrentUser.getInstance().getUser().getAdmin()){
            toModif.setAdmin(false);
            userService.addUser(toModif);
            logger.info("Admin "+CurrentUser.getInstance().getUser().getPseudo()+" removed as admin user "+toModif.getPseudo());
            return "redirect:http://localhost:8080/userPage/fill";

        }else{
            if(CurrentUser.getInstance().isConnected())
                logger.warn("User "+CurrentUser.getInstance().getUser().getPseudo()+" is trying to remove as admin "+toModif.getPseudo());
            else
                logger.warn("Anonymous user is trying to remove as admin "+toModif.getPseudo());
            return "redirect:http://localhost:8080/welcome";
        }
    }
}
