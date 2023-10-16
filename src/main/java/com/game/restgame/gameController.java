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

    @GetMapping("/")
    public String homepage(){
        return this.gameService.getHomePage();
    }

    @PostMapping("/game")
    public String createGame(@RequestParam String balance){   
        return this.gameService.postCreateGame(balance);
    }

}
