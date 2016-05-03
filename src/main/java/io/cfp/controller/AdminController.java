package io.cfp.controller;

import io.cfp.domain.Event;
import io.cfp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sguernion on 03/05/2016.
 */
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    public Event putEvent(@RequestBody Event event)  {
        return eventService.updateEvent(event);
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public Event postEvent(@RequestBody Event event)  {
        return eventService.addEvent(event);
    }
}
