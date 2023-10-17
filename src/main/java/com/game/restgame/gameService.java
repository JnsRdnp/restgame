package com.game.restgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        homeJson.put("/setbalance","Set your balance POST /setbalance?balance=x");
        homeJson.put("/setBetsize","Set your betsize POST /setbetsize?bet=x");
        homeJson.put("/hit","Deal a card for the player GET");
        homeJson.put("/stay","Player stay on number and deal for dealer GET");
        homeJson.put("/values","Current Game values in JSON GET");
        homeJson.put("/save","Save current game object to a file GET");
        homeJson.put("/getsaved","Get saved Game object from a file and overwrite current Game object GET");


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
        return Game1.hit();
    }

    public String getStay(){
        //Deal for dealer and find out who won. Also reset numbers
        results = this.Game1.stay();
        this.Game1.resetNumbers();
        return results;
    }

    //Json demoing
    public String getGame(String params) {
        // return String.format("Balance: %d Betsize: %d  Players hand: %d Dealers hand: %d",this.Game1.getBalance(),this.Game1.getBetAmount(),this.Game1.getPlayerNumber(),this.Game1.getDealerNumber());
        if (params != null) {
            switch(params){
                case "balance":
                    return String.format("Balance: d%",this.Game1.getBalance());
                case "betsize":
                    return String.format("Betsize: d%",this.Game1.getBetAmount());
            }

        } else{
            // return String.valueOf(this.Game1.getBalance(), this);
            return String.format("Balance: %d\nBetsize: %d\nPlayers hand: %d\nDealers hand: %d",this.Game1.getBalance(),this.Game1.getBetAmount(),this.Game1.getPlayerNumber(),this.Game1.getDealerNumber());
        }
        
        //return "hello";
    }

    public void saveObjectProperties() {
        try {
            FileOutputStream fileStream = new FileOutputStream("gameObjects.txt");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(this.Game1);

            // Close the streams when done
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game getSavedPropertiesAndOverwrite() {
        try {
			FileInputStream fi = new FileInputStream(new File("gameObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

            Game GameSaved = (Game) oi.readObject();

            // Close the streams when done
            oi.close();
            fi.close();
            this.Game1 = GameSaved;
            return this.Game1;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
