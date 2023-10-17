package com.game.restgame;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

//Business logic
@Service
public class gameService {
    Game Game1 = new Game(100);
    String results;

    public Map<String,String> getHomePage(){
        Map<String,String> homeJson = new LinkedHashMap<>();
        homeJson.put("/","Endpoint info for this Blackjack style game");
        homeJson.put("/setBalance","Set your balance POST(balance=)");
        homeJson.put("/setBetsize","Set your betsize POST(bet=)");
        homeJson.put("/hit","Deal a card for the player GET");
        homeJson.put("/stay","Player stay on number and deal for dealer GET");


        return homeJson;
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
