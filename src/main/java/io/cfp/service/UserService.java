package io.cfp.service;

import io.cfp.domain.Event;
import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sguernion on 03/05/2016.
 */
@Component
public class UserService {

    // temporaire
    private static List<UserProfil> users = new ArrayList<>();
    private static Map<Integer,List<Speaker>> speakers = new HashMap<>();

    static{
        Speaker speaker = new Speaker(new UserProfil(1,"toto","tata","mon@Email.com"),"ma bio");
        List<Speaker> sp = new ArrayList<Speaker>();
        sp.add(speaker);
        speakers.put(speaker.getUser().getId(),sp);

        users.add(speaker.getUser());
    }

    public UserProfil getUser(int userId) {
        return users.stream().filter(r -> r.getId() == userId ).findAny().get();
    }

    public UserProfil updateUser(int userId, UserProfil profil) {
        return profil;
    }

    public List<Speaker> getSpeakers(int userId) {
        return speakers.get(userId);
    }

    public Speaker updateSpeaker(String speakerId, Speaker speaker) {

        return speaker;
    }

    /**
     * ajoute une biographie
     * @param speaker
     * @return
     */
    public Speaker addSpeaker(int  userId,Speaker speaker) {
      speakers.get(userId).add(speaker);
        return speaker;
    }

    /**
     * retourne une biographie
     *
     * @param userId
     * @param speakerId
     * @return
     */
    public Speaker getSpeaker(int userId, int speakerId) {
        return speakers.get(userId).stream().filter(r -> r.getId() == speakerId ).findAny().get();
    }

    /**
     * suppression d'une biograhpie
     * @param speakerId
     */
    public void deleteSpeaker(int userId,int speakerId) {
        Speaker speaker = speakers.get(userId).stream().filter(r -> r.getId() == speakerId ).findAny().get();
        speakers.get(userId).remove(speaker);
    }
}
