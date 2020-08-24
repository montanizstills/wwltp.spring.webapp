package com.github.wwltp.controllers;

import com.github.wwltp.services.FacebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping(value = "/server")
public class FacebookController {

    private final FacebookService facebookService;

    public FacebookController(FacebookService facebookService){
        this.facebookService=facebookService;
    }

    @GetMapping(value="/myfacebookapi")
    public ResponseEntity<String> responseEntity(){
        return new ResponseEntity(facebookService.hitFacebookEndpoint(), HttpStatus.OK);
    }


}
