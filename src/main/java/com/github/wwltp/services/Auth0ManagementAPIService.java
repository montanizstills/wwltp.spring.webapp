package com.github.wwltp.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Auth0ManagementAPIService {

    private String managementAPIAccessToken;
    private HttpResponse<String> response = null;
    private JSONObject httpResponse;
    private String userProfile;

    public Auth0ManagementAPIService() {
    }

    public String getManagementAPIAccessToken() {
        try {
            this.response = Unirest.post("https://wwltp.auth0.com/oauth/token")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body("grant_type=client_credentials&client_id=" + System.getenv("client_id") + "&client_secret=" + System.getenv("client_secret") + "&audience=https://wwltp.auth0.com/api/v2/").asString();
        } catch (UnirestException e) {
            throw new Error(e);
        }
        this.httpResponse = new JSONObject(this.response.getBody());
        return this.managementAPIAccessToken = httpResponse.get("access_token").toString();
    }

    public String getUsersEndpoint() {
        try {
            this.response = Unirest.get("https://wwltp.auth0.com/api/v2/users").header("Authorization", "Bearer " + this.managementAPIAccessToken).asString();
        } catch (UnirestException e) {
            throw new Error(e);
        }
        //array full of JsonObjects with string to string mappings
        JSONArray jsonArray = new JSONArray(this.response.getBody());
        return this.userProfile = jsonArray.toString();
    }
}
