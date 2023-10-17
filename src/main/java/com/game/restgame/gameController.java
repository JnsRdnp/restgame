package com.game.restgame;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Only for endpoint routing
@RestController
public class gameController {
    
    @Autowired
    private gameService gameService;

    public gameController(gameService service){
        this.gameService = service;
    }
    //Info etc
    @GetMapping("/")
    public String homepage(){
        return this.gameService.getHomePage();
    }
    //Set players balance
    @PostMapping("/setbalance")
    public String createGame(@RequestParam Integer balance){   
        return this.gameService.postBalance(balance);
    }
    //Set size of bets
    @PostMapping("/setbetsize")
    public String betsize(@RequestParam Integer bet){   
        return this.gameService.postBetsize(bet);
    }
    //Deal for player
    @GetMapping("/hit")
    public String hit(){
        return this.gameService.getHit();
    }
    //Stay and deal for dealer
    @GetMapping("/stay")
    public String stay(){
        return this.gameService.getStay();
    }

    @GetMapping("/values")
    public Game getProp(){

        return gameService.getGame();
    }
}
