package io.cfp.controller;

import io.cfp.domain.Event;
import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguernion on 03/05/2016.
 */

@RestController
@RequestMapping(value = "/api")
public class CfpController {

    // temporaire
    private static List<Event> events = new ArrayList<>();

    static{
        events.add(new Event("BreizhCamp 2016"));
        events.add(new Event("Devoxx 2016"));
        events.add(new Event("Hackathon CFP.io"));
    }

    @RequestMapping(value="/events", method= RequestMethod.GET, produces="application/json")
    public List<Event> allEvent(){
        return events;
    }
}
