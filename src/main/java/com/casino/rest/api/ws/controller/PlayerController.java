package com.casino.rest.api.ws.controller;

import com.casino.rest.api.ws.service.PlayerService;
import com.casino.rest.api.ws.shared.dto.GameDetailsDto;
import com.casino.rest.api.ws.shared.dto.PlayerDetailsDto;
import com.casino.rest.api.ws.ui.model.response.GamesDetailsRestResponse;
import com.casino.rest.api.ws.ui.model.request.PlayerDetailsRequestModel;
import com.casino.rest.api.ws.ui.model.response.PlayerDetailsRestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("casino")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("getGamesForPlayer")
    public List<GamesDetailsRestResponse> getTop10WonGamesForPlayer(@RequestParam String emailAddress){
        List<GamesDetailsRestResponse> gamesDetailsRestResponseList = new ArrayList<>();
        List<GameDetailsDto> gameDetailsDtoList = playerService.getLatest10WagerForPlayer(0,10,emailAddress);
        gameDetailsDtoList.forEach(gameDetailsDto -> {
            GamesDetailsRestResponse gamesDetailsRestResponse = new GamesDetailsRestResponse();
            BeanUtils.copyProperties(gameDetailsDto,gamesDetailsRestResponse);
            gamesDetailsRestResponseList.add(gamesDetailsRestResponse);
        });
        return gamesDetailsRestResponseList;
    }

    @PostMapping("addPlayer")
    public String addPlayer(@RequestBody PlayerDetailsRequestModel playerDetailsRequestModel){
        PlayerDetailsDto playerDetailsDto = new PlayerDetailsDto();
        BeanUtils.copyProperties(playerDetailsRequestModel,playerDetailsDto);
        List<GameDetailsDto> gameDetailsDtoList = new ArrayList<>();
        playerDetailsRequestModel.getGames().forEach(gameDetailsRequestModel -> {
            GameDetailsDto gameDetailsDto = new GameDetailsDto();
            BeanUtils.copyProperties(gameDetailsRequestModel,gameDetailsDto);
            gameDetailsDtoList.add(gameDetailsDto);
        });
        playerDetailsDto.setGames(gameDetailsDtoList);
        playerService.savePlayerGames(playerDetailsDto);
        return "Player " + playerDetailsRequestModel.getFirstName() + " " + playerDetailsRequestModel.getLastName() + " was added successfully!!";
    }

}
