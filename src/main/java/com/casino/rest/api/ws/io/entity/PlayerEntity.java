package com.casino.rest.api.ws.io.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name="players")
public class PlayerEntity implements Serializable {
    private static final long serialVersionUID = 270037945028367438L;

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 150, unique = true)
    private String emailAddress;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "player_game",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    List<GameEntity> games;


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

    public List<GameEntity> getGames() {
        return games;
    }

    public void setGames(List<GameEntity> games) {
        this.games = games;
    }
}
