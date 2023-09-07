package com.casino.rest.api.ws.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name="games")
public class GameEntity implements Serializable {
    private static final long serialVersionUID = 4487837618920231502L;

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean wagerStatus;

    @Column(nullable = false)
    private LocalDateTime datePlayed;

    @Column(nullable = false, length = 15)
    private int slotNumber;

    @Column(nullable = false, length = 100)
    private String companyName;

    @ManyToMany(mappedBy = "games")
    @JsonIgnore
    List<PlayerEntity> players;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWagerStatus() {
        return wagerStatus;
    }

    public void setWagerStatus(Boolean wagerStatus) {
        this.wagerStatus = wagerStatus;
    }

    public LocalDateTime getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(LocalDateTime datePlayed) {
        this.datePlayed = datePlayed;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}
