package jee.web.controller;

import jee.core.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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

        if (userService.canUserConnect(pseudo,password)) return Response.Status.ACCEPTED;
        else return Response.Status.BAD_REQUEST;
    }
}
