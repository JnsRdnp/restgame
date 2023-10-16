package com.game.restgame;

import org.springframework.stereotype.Service;

//Business logic
@Service
public class gameService {

    public String getHomePage(){
        return "This is the homepage, service";
    }

    public String getTesti(){
        return "Is this service working";
    }
}
