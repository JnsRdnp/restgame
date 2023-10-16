package com.game.restgame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gameController {
    @GetMapping("/")
    public String homepage(){
        return "This the root";
    }

    // @GetMapping("/servicetest")
    // public 

}
