package com.github.wwltp.services;

import com.github.wwltp.models.User;
import com.github.wwltp.repositories.FacebookRepository;
import com.github.wwltp.utils.interfaces.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookService implements ServiceInterface<
        Long,
        User,
        FacebookRepository> {

    private final FacebookRepository facebookRepository;

    @Autowired
    public FacebookService(FacebookRepository facebookRepository) {
        this.facebookRepository = facebookRepository;
    }

    @Override
    public FacebookRepository getRepository() {
        return this.facebookRepository;
    }

    @Override
    public User update(User entity) {
        return getRepository().save(entity);
    }
}
