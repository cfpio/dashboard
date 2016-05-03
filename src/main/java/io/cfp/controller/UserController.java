package io.cfp.controller;

import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
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

    // temporaire
    private UserProfil userProfil = new UserProfil(1,"toto","tata","mon@Email.com");


    @RequestMapping(value="/user", method= RequestMethod.GET, produces="application/json")
    public UserProfil getUser(){
        return userProfil;

    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public UserProfil putUserProfil(@RequestBody UserProfil profil)  {
        userProfil = profil;
        return userProfil;
    }
}
