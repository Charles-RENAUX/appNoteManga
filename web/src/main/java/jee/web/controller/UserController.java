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

@Named
@Controller
@Path("/users")
public class UserController implements RestController{

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @POST
    @Path("/users/try_Connection")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response.Status userConnection(@FormParam("pseudo")String pseudo, @FormParam("password")String password){

        if (userService.canUserConnect(pseudo,password)) {
            // set session
            Users user = userService.findUserByConnexion(pseudo, password);
            CurrentUser.getInstance().setUser(user);
            return Response.Status.ACCEPTED;
        }
        else return Response.Status.BAD_REQUEST;
    }

    @RequestMapping(value = "/addUser/form", method = RequestMethod.POST)
    private String submitForm(@ModelAttribute("user") Users user){
        userService.addUser(user); ;
        return "redirect:http://localhost:8080/welcome";
    }

    @GetMapping("/User")
    private String getUser(ModelMap map) {
        Users user = CurrentUser.getInstance().getUser();
        System.out.println("Dans le controller: "+user);
        map.addAttribute("user", user);
        map.addAttribute("connected", true);
        return "userPge";
    }
}
