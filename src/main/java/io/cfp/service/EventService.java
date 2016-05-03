package io.cfp.service;

import io.cfp.domain.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguernion on 03/05/2016.
 */
@Component
public class EventService {

    // temporaire
    private static List<Event> events = new ArrayList<>();

    static{
        events.add(new Event(1,"BreizhCamp 2016"));
        events.add(new Event(2,"Devoxx 2016"));
        events.add(new Event(3,"Hackathon CFP.io"));
    }

    public List<Event> getEvents(){
        return events;
    }

    public Event updateEvent(Event event) {
        Event eventDb = events.stream().filter(r -> r.getId() == event.getId() ).findAny().get();
        events.remove(eventDb);
        events.add(event);
        return event;
    }

    public Event addEvent(Event event) {
        events.add(event);
        return event;
    }
}
