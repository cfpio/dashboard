package io.cfp.controller;

import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
import io.cfp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sguernion on 03/05/2016.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="/user", method= RequestMethod.GET, produces="application/json")
    public UserProfil getUser(){
        return userService.getCurrentUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public UserProfil putUserProfil(@RequestBody UserProfil profil)  {
        return userService.updateUser(profil);
    }
}
