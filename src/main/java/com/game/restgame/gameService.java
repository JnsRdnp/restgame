package com.game.restgame;

import org.springframework.stereotype.Service;

//Business logic
@Service
public class gameService {
    Game Game1 = new Game(100);

    public String getHomePage(){
        return "This is the homepage, service";
    }

    public String postBalance(Integer balance){
        Game1.setBalance(balance);
        return "Balance set to "+Game1.toString();
    }

    public String postBetsize(Integer bet){
        this.Game1.setBetAmount(bet);
        return "Bet amount set to "+String.valueOf(this.Game1.getBetAmount());
    }
}
