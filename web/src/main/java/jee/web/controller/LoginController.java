package jee.web.controller;

import jee.core.entity.Users;
import jee.core.service.UserService;
import jee.web.utils.CurrentUser;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;

@org.springframework.web.bind.annotation.RestController
public class LoginController{

    private UserService userService;

    public LoginController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value="/login/try", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RedirectView userConnection(@RequestBody String body){

        JSONObject bodyJson = new JSONObject(body);

        if (userService.canUserConnect(bodyJson.get("pseudo").toString(),bodyJson.get("password").toString())) {
            // set session
            Users user = userService.findUserByConnexion(bodyJson.get("pseudo").toString(), bodyJson.get("password").toString());
            System.out.println("TRYING TO LOG: " + bodyJson.get("pseudo").toString() + " mdp: " + bodyJson.get("password").toString());
            CurrentUser.getInstance().setUser(user);
            System.out.println("CONNECTED");
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http:/localhost:8080/welcome");

        return redirectView;
    }
}
