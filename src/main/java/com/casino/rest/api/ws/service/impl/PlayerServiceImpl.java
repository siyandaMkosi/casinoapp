package com.casino.rest.api.ws.service.impl;

import com.casino.rest.api.ws.io.entity.GameEntity;
import com.casino.rest.api.ws.io.entity.PlayerEntity;
import com.casino.rest.api.ws.io.repository.GameRepository;
import com.casino.rest.api.ws.io.repository.PlayerRepository;
import com.casino.rest.api.ws.service.PlayerService;
import com.casino.rest.api.ws.shared.dto.GameDetailsDto;
import com.casino.rest.api.ws.shared.dto.PlayerDetailsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;
    @Override
    public List<GameDetailsDto> getLatest10WagerForPlayer(int page, int limit, String emailAddress) {
        List<GameDetailsDto> gameDetailsDtoList = new ArrayList<>();
        PlayerEntity player = playerRepository.findDistinctByEmailAddress(emailAddress);
        Pageable pageableRequest = PageRequest.of(page,limit);
        Page<GameEntity> gameEntityPage = gameRepository.findTop10ByWagerStatusAndPlayersOrderByDatePlayedDesc(true,player,pageableRequest);
        List<GameEntity> gameEntityList = gameEntityPage.getContent();
        gameEntityList.forEach(gameEntity -> {
            GameDetailsDto gameDetailsDto = new GameDetailsDto();
            BeanUtils.copyProperties(gameEntity,gameDetailsDto);
            gameDetailsDtoList.add(gameDetailsDto);
        });
        return gameDetailsDtoList;
    }

    @Override
    public void savePlayerGames(PlayerDetailsDto playerDetailsDto){
        PlayerEntity player = new PlayerEntity();
        BeanUtils.copyProperties(playerDetailsDto,player);
        List<GameEntity> gameEntityList = new ArrayList<>();
        playerDetailsDto.getGames().forEach(gameDetailsDto -> {
            GameEntity game = new GameEntity();
            BeanUtils.copyProperties(gameDetailsDto,game);
            gameEntityList.add(game);
        });
        player.setGames(gameEntityList);
        gameRepository.saveAll(gameEntityList);
        playerRepository.save(player);
    }
}
