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
        //LinkedHashMap to ensure the order of the JSON map
        Map<String,String> homeJson = new LinkedHashMap<>();
        homeJson.put("/","Endpoint info for this Blackjack style game");
        homeJson.put("/setBalance","Set your balance POST(balance=)");
        homeJson.put("/setBetsize","Set your betsize POST(bet=)");
        homeJson.put("/hit","Deal a card for the player GET");
        homeJson.put("/stay","Player stay on number and deal for dealer GET");


        return homeJson;
    }

    public Game postBalance(Integer balance){
        //setting balance and returning Game1 JSON
        Game1.setBalance(balance);
        return Game1;
    }

    public String postBetsize(Integer bet){
        //setting betsize and returning Game1 betsize String
        this.Game1.setBetAmount(bet);
        return "Bet amount set to "+String.valueOf(this.Game1.getBetAmount());
    }

    public Game getHit(){
        //Perform dealing card for player
        results = this.Game1.hit();
        //Reset playernumber if it goes over 21
        if(results.contains("over")){
            this.Game1.resetNumbers();
        }
        //Return Game1 in json
        return this.Game1;
    }

    public String getStay(){
        //Deal for dealer and find out who won. Also reset numbers
        results = this.Game1.stay();
        this.Game1.resetNumbers();
        return results;
    }

    //Json demoing
    public Game getGame(){
        return this.Game1;
    }




}
