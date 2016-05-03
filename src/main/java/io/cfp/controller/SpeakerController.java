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
public class SpeakerController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/speakers", method= RequestMethod.GET, produces="application/json")
    public List<Speaker> getSpeakers(){
        return userService.getSpeakers();
    }

    @RequestMapping(value="/speakers/{uid}", method= RequestMethod.GET, produces="application/json")
    public Speaker getSpeaker(@PathVariable("uid") int speakerId){
        return userService.getSpeaker(speakerId);
    }

    @RequestMapping(value = "/speakers/{uid}", method = RequestMethod.PUT)
    public Speaker putSpeaker(@PathVariable("uid") String speakerId,@RequestBody Speaker speaker)  {
        return userService.updateSpeaker(speakerId,speaker);
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.POST)
    public Speaker postSpeaker(@RequestBody Speaker speaker)  {
        return userService.addSpeaker(speaker);
    }

    @RequestMapping(value = "/speakers/{uid}", method = RequestMethod.DELETE)
    public void postSpeaker(@PathVariable("uid") int speakerId)  {
        userService.deleteSpeaker(speakerId);
    }
}
