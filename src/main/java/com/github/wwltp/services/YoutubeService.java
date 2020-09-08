package com.github.wwltp.services;

import com.github.wwltp.models.User;
import com.github.wwltp.repositories.YoutubeRepository;
import com.github.wwltp.utils.interfaces.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class YoutubeService implements ServiceInterface<
        Long,
        User,
        YoutubeRepository> {

    private final YoutubeRepository youtubeRepository;

    @Autowired
    public YoutubeService(YoutubeRepository youtubeRepository) {
        this.youtubeRepository = youtubeRepository;
    }

    @Override
    public YoutubeRepository getRepository() {
        return this.youtubeRepository;
    }

    @Override
    public User update(User entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(User entity) {
        getRepository().delete(entity);
    }

}
