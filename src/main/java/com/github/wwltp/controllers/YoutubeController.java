package com.github.wwltp.controllers;

import com.github.wwltp.models.User;
import com.github.wwltp.repositories.YoutubeRepository;
import com.github.wwltp.services.YoutubeService;
import com.github.wwltp.utils.interfaces.controllers.ControllerInterface;
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
public class YoutubeController implements ControllerInterface<
        Long,
        User,
        YoutubeRepository,
        YoutubeService> {

    private final YoutubeService youtubeService;

    @Autowired
    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public YoutubeService getService() {
        return this.youtubeService;
    }

    @GetMapping(value = "/getCategories")
    public ResponseEntity categories(){
        return new ResponseEntity(youtubeService.getVideoCategoryList(), HttpStatus.OK);
    }

}
