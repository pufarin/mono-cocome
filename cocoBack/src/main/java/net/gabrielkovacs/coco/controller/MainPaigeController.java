package net.gabrielkovacs.coco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPaigeController {

    @GetMapping("/")
    public String index(){
        return "Greetings frommmmm Spring Boot aaaaaaa!!!";
    }


    
    @GetMapping("/abc")
    public String indexNew(){
        return "Greetings from the other sdasds   ide";
    }

}