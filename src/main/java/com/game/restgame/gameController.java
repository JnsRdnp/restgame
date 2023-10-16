package com.game.restgame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Only for endpoint routing
@RestController
public class gameController {
    
    gameService gameService;

    public gameController(gameService service){
        this.gameService = service;
    }

    @GetMapping("/")
    public String homepage(){
        return this.gameService.getHomePage();
    }

    @GetMapping("/servicetest")
    public String testi(){
        return this.gameService.getTesti();
    }

}
