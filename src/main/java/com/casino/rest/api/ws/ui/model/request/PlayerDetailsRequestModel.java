package com.casino.rest.api.ws.ui.model.request;

import java.util.List;

public class PlayerDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String emailAddress;

    private List<GameDetailsRequestModel> games;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<GameDetailsRequestModel> getGames() {
        return games;
    }

    public void setGames(List<GameDetailsRequestModel> games) {
        this.games = games;
    }
}
