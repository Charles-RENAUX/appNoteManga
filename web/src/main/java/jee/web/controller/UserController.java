package jee.web.controller;

import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.entity.Users;
import jee.core.service.MangaService;
import jee.core.service.UserService;
import jee.web.utils.CurrentUser;
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
        if(userService.doesUserPseudoAlreadyExist(user)){
            map.addAttribute("pseudoDouble", true);
            return "redirect:http://localhost:8080/user/registration/fill";
        }else
        {
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
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/logOff")
    private String logOffCurrentUser(ModelMap map){
        CurrentUser.getInstance().logOff();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/userPage/form", method = RequestMethod.POST)
    private String modifyUser(@ModelAttribute("user") Users user, ModelMap map) throws InterruptedException {
        if(CurrentUser.getInstance().isConnected()) {
            user.setId(CurrentUser.getInstance().getUser().getId());
            userService.addUser(user);
            Users newU = userService.findUser(user.getId());
            CurrentUser.getInstance().logOff();
            CurrentUser.getInstance().setUser(newU);
            return "redirect:http://localhost:8080/userPage/fill";
        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/permission/addAdmin/{id}")
    public String changeUserAdmin(@PathVariable("id") long userId){
        if(CurrentUser.getInstance().getUser().getAdmin()){
            Users toModif = userService.findUser(userId);
            toModif.setAdmin(true);
            userService.addUser(toModif);
            return "redirect:http://localhost:8080/userPage/fill";

        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }

    @GetMapping("/permission/rmAdmin/{id}")
    public String changeUserNotAdmin(@PathVariable("id") long userId){
        if(CurrentUser.getInstance().getUser().getAdmin()){
            Users toModif = userService.findUser(userId);
            toModif.setAdmin(false);
            userService.addUser(toModif);
            return "redirect:http://localhost:8080/userPage/fill";

        }else{
            return "redirect:http://localhost:8080/welcome";
        }
    }
}
