package io.cfp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by sguernion on 03/05/2016.
 */
public class Speaker {



    private UserProfil user;
    private String bio;

    public Speaker(UserProfil user,String bio) {
        this.bio = bio;
        this.user = user;
    }

    public String getMail() {
        return user.getMail();
    }

    public String getName() {
        return user.getName();
    }

    public String getLastname() {
        return user.getLastname();
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @JsonIgnore
    public UserProfil getUser() {
        return user;
    }

    public void setUser(UserProfil user) {
        this.user = user;
    }
}
