package com.github.wwltp.controllers;

import com.github.wwltp.services.subservices.Auth0ManagementAPISubservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping(value = "/server")
public class Auth0ManagementAPIController {

    private final Auth0ManagementAPISubservice auth0ManagementAPIService;

    @Autowired
    public Auth0ManagementAPIController(Auth0ManagementAPISubservice auth0ManagementAPIService) {
        this.auth0ManagementAPIService = auth0ManagementAPIService;
    }

    @GetMapping(value = "/auth0Identity")
    public ResponseEntity<String> auth0Identity() {
        return new ResponseEntity<>(auth0ManagementAPIService.getUserProfile(), HttpStatus.OK);
    }


}
