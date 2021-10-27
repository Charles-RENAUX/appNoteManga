package jee.web.controller;

import jee.core.entity.Users;
import jee.core.service.UserService;
import jee.web.utils.CurrentUser;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value="/login/try", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void userConnection(@RequestBody String body, HttpServletResponse httpResponse) throws IOException {

        JSONObject bodyJson = new JSONObject(body);

        logger.info("Trying to log in: "+bodyJson.get("pseudo").toString());

        if (userService.canUserConnect(bodyJson.get("pseudo").toString(),bodyJson.get("password").toString())) {
            Users user = userService.findUserByConnexion(bodyJson.get("pseudo").toString(), bodyJson.get("password").toString());
            CurrentUser.getInstance().setUser(user);
            logger.info("Log in succesfull");
            httpResponse.sendRedirect("/welcome");
        }else{
            logger.info("Error, cannot log in, wrong credentials");
            httpResponse.setStatus(403);
        }
    }
}
