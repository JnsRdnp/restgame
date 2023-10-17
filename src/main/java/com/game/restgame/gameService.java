package com.game.restgame;

import java.util.Map;

import org.apache.catalina.valves.JsonAccessLogValve;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.util.JSONPObject;

//Business logic
@Service
public class gameService {
    Game Game1 = new Game(100);
    String results;

    public String getHomePage(){
        return "This is the homepage, service";
    }

    public Game postBalance(Integer balance){
        Game1.setBalance(balance);
        return Game1;
    }

    public String postBetsize(Integer bet){
        this.Game1.setBetAmount(bet);
        return "Bet amount set to "+String.valueOf(this.Game1.getBetAmount());
    }

    public Game getHit(){
        results = this.Game1.hit();
        if(results.contains("over")){
            this.Game1.resetNumbers();
        }
        return this.Game1;
    }

    public String getStay(){
        results = this.Game1.stay();
        this.Game1.resetNumbers();
        return results;
    }

    public Game getGame(){
        return this.Game1;
    }




}
