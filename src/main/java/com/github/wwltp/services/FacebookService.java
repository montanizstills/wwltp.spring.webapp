package com.github.wwltp.services;

import org.springframework.stereotype.Service;

@Service
public class FacebookService {

    public FacebookService() {
    }

    public String hitFacebookEndpoint() {
        Auth0ManagementAPIService auth0ManagementAPIService = new Auth0ManagementAPIService();
        auth0ManagementAPIService.getManagementAPIAccessToken();
        String userProfile = auth0ManagementAPIService.getUsersEndpoint();
        return userProfile;
    }

}
