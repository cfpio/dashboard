package io.cfp.controller;

import io.cfp.domain.Speaker;
import io.cfp.domain.UserProfil;
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

    // temporaire
    private static Map<Integer,List<Speaker>> speakers = new HashMap<>();

    static{
        Speaker speaker = new Speaker(new UserProfil(1,"toto","tata","mon@Email.com"),"ma bio");
        List<Speaker> sp = new ArrayList<Speaker>();
        sp.add(speaker);
        speakers.put(1,sp);
    }

    @RequestMapping(value="/user/{uid}/speakers", method= RequestMethod.GET, produces="application/json")
    public List<Speaker> getSpeaker(@PathVariable("uid") int userId){
        return speakers.get(userId);

    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.PUT)
    public Speaker putUserProfil(@PathVariable("uid") String userId,@RequestBody Speaker profil)  {
        speakers.get(userId).add(profil);
        return profil;
    }
}
