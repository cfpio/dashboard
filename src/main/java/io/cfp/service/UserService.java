package io.cfp.service;

import io.cfp.domain.Event;
import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sguernion on 03/05/2016.
 */
public class UserService {

    // temporaire
    private static List<UserProfil> users = new ArrayList<>();
    private static Map<Integer,List<Speaker>> speakers = new HashMap<>();

    static{
        Speaker speaker = new Speaker(new UserProfil(1,"toto","tata","mon@Email.com"),"ma bio");
        List<Speaker> sp = new ArrayList<Speaker>();
        sp.add(speaker);
        speakers.put(1,sp);

        users.add(speaker.getUser());
    }

    public UserProfil getCurrentUser() {
        return users.get(0);
    }

    public UserProfil updateUser(UserProfil profil) {
        return profil;
    }


    public List<Speaker> getSpeakers() {
        return speakers.get(1);
    }

    public Speaker updateSpeaker(String speakerId, Speaker speaker) {

        return speaker;
    }


    public Speaker addSpeaker(Speaker speaker) {
      speakers.get(1).add(speaker);
        return speaker;
    }

    public Speaker getSpeaker(int speakerId) {
        return speakers.get(1).stream().filter(r -> r.getId() == speakerId ).findAny().get();
    }


    public void deleteSpeaker(int speakerId) {
        Speaker speaker = speakers.get(1).stream().filter(r -> r.getId() == speakerId ).findAny().get();
        speakers.get(1).remove(speaker);
    }
}
