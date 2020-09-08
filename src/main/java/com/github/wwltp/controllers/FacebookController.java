package com.github.wwltp.controllers;

import com.github.wwltp.models.User;
import com.github.wwltp.repositories.FacebookRepository;
import com.github.wwltp.services.FacebookService;
import com.github.wwltp.utils.interfaces.controllers.ControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class FacebookController implements ControllerInterface<
        Long,
        User,
        FacebookRepository,
        FacebookService> {

    private final FacebookService facebookService;

    @Autowired
    public FacebookController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @Override
    public FacebookService getService() {
        return this.facebookService;
    }
}
