package io.cfp.controller;

import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
import io.cfp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sguernion on 03/05/2016.
 */
@RestController
@RequestMapping(value = "/api")
public class SpeakerController extends RestrictedController{

    @Autowired
    private UserService userService;

    /**
     * Retourne les biographies de l'utilisateur
     * @return
     */
    @RequestMapping(value="/speakers", method= RequestMethod.GET, produces="application/json")
    public List<Speaker> getSpeakers(){
        return userService.getSpeakers(retrieveUserId());
    }

    /**
     * Retourne une biographie de l'utilisateur
     * @param speakerId
     * @return
     */
    @RequestMapping(value="/speakers/{uid}", method= RequestMethod.GET, produces="application/json")
    public Speaker getSpeaker(@PathVariable("uid") int speakerId){
        return userService.getSpeaker(retrieveUserId(),speakerId);
    }

    /**
     * modifie une biographie de l'utilisateur
     * @param speakerId
     * @param speaker
     * @return
     */
    @RequestMapping(value = "/speakers/{uid}", method = RequestMethod.PUT)
    public Speaker putSpeaker(@PathVariable("uid") String speakerId,@RequestBody Speaker speaker)  {
        return userService.updateSpeaker(speakerId,speaker);
    }

    /**
     * ajout d'une biographie
     * @param speaker
     * @return
     */
    @RequestMapping(value = "/speakers", method = RequestMethod.POST)
    public Speaker postSpeaker(@RequestBody Speaker speaker)  {
        return userService.addSpeaker(retrieveUserId(),speaker);
    }

    /**
     * suppression d'une biographie
     * @param speakerId
     */
    @RequestMapping(value = "/speakers/{uid}", method = RequestMethod.DELETE)
    public void postSpeaker(@PathVariable("uid") int speakerId)  {
        userService.deleteSpeaker(retrieveUserId(),speakerId);
    }

}
