package com.casino.rest.api.ws.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PlayerDetailsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String emailAddress;

    private List<GameDetailsDto> games;

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

    public List<GameDetailsDto> getGames() {
        return games;
    }

    public void setGames(List<GameDetailsDto> games) {
        this.games = games;
    }

}
