package jee.web.controller;

import jee.core.entity.Manga;
import jee.core.entity.Review;
import jee.core.entity.Users;
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

    public UserController(UserService userService){
        this.userService=userService;
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
}
