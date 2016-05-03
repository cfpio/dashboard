package io.cfp.domain;

/**
 * Created by sguernion on 03/05/2016.
 */
public class Event {

    private String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
