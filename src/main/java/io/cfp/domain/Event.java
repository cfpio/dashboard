package io.cfp.domain;

/**
 * Created by sguernion on 03/05/2016.
 */
public class Event {


    private int id;
    private String name;

    public Event(int id,String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
