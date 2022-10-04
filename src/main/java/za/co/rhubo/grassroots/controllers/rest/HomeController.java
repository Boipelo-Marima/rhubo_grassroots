package za.co.rhubo.grassroots.controllers.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String getHome(){
        return "We are home";

    }
}
