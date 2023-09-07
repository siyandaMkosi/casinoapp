package com.casino.rest.api.ws.ui.model.response;

import java.time.LocalDateTime;

public class GamesDetailsRestResponse {
    private String name;

    private Boolean wagerStatus;

    private LocalDateTime datePlayed;

    private int slotNumber;

    private String companyName;

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
}
