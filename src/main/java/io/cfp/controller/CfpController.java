package io.cfp.controller;

import io.cfp.domain.Event;
import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
import io.cfp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguernion on 03/05/2016.
 */

@RestController
@RequestMapping(value = "/api")
public class CfpController {

    @Autowired
    private EventService eventService;

    /**
     * retourne l'ensemble des CFP
     * @return
     */
    @RequestMapping(value="/events", method= RequestMethod.GET, produces="application/json")
    public List<Event> allEvent(){
        return eventService.getEvents();
    }

    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    public Event putEvent(@RequestBody Event event)  {
        return eventService.updateEvent(event);
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public Event postEvent(@RequestBody Event event)  {
        return eventService.addEvent(event);
    }
}
