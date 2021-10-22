package jee.web.controller;

import jee.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Named
@Controller
@Path("/users")
public class UserController implements RestController{

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GET
    @Path("/users/try_Connection")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean userConnection(){
        return false;
    }
}
