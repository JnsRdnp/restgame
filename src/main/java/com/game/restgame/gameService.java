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

    public String postCreateGame(Integer balance){
        Game Game1 = new Game(balance);
        return "Game created with balance of "+Game1.toString();
    }
}
