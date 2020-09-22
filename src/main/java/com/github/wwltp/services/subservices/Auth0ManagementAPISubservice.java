package com.github.wwltp.services.subservices;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Auth0ManagementAPISubservice {

    private static String managementAPIAccessToken;
    private static HttpResponse<String> response;
    private String userProfile;


    public Auth0ManagementAPISubservice() {
    }

    public String getUserProfile() {
        Auth0ManagementAPISubservice auth0ManagementAPISubservice = new Auth0ManagementAPISubservice();
        this.userProfile = auth0ManagementAPISubservice.getUsers();
        return userProfile;
    }

    /*
     *
     *
     *
     * Access the /User endpoint of the Management API
     *
     *
     *
     * */
    private String getUsers() {
        try {
            response = Unirest.get("https://wwltp.auth0.com/api/v2/users").header("Authorization", "Bearer " + managementAPIAccessToken).asString();
        } catch (UnirestException e) {
            throw new Error(e);
        }
        //array full of JsonObjects with string to string mappings
        System.out.println(response.getBody());
        JSONArray jsonArray = new JSONArray(response.getBody());
        return this.userProfile = jsonArray.toString();
    }

    static {
        try {
            response = Unirest.post("https://wwltp.auth0.com/oauth/token")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body("grant_type=client_credentials&client_id=" + System.getenv("auth0_client_id") + "&client_secret=" + System.getenv("auth0_client_secret") + "&audience=https://wwltp.auth0.com/api/v2/&scope=read:user_idp_tokens").asString();
        } catch (UnirestException e) {
            throw new Error(e);
        }
        JSONObject httpResponse = new JSONObject(response.getBody());
        managementAPIAccessToken = httpResponse.get("access_token").toString();
    }
}
