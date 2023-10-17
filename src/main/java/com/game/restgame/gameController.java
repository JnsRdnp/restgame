package com.game.restgame;

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
    //Set player balance and returns properties in JSON
    @PostMapping("/setbalance")
    public Game createGame(@RequestParam Integer balance){   
        return this.gameService.postBalance(balance);
    }
    //Set size of bets and returns String of betsize
    @PostMapping("/setbetsize")
    public String betsize(@RequestParam Integer bet){   
        return this.gameService.postBetsize(bet);
    }

    //Deal card for player and return JSON of BALANCE,betsize,playersnumber,dealernumber
    @GetMapping("/hit")
    public Game hit(){
        return this.gameService.getHit();
    }

    //Stay, deal for dealer and tell who won and adjust the balance
    @GetMapping("/stay")
    public String stay(){
        return this.gameService.getStay();
    }

    @GetMapping("/values")
    public Game getProp(){
        return gameService.getGame();
    }
}
