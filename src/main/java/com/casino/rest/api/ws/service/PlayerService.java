package com.casino.rest.api.ws.service;

import com.casino.rest.api.ws.io.entity.PlayerEntity;
import com.casino.rest.api.ws.shared.dto.GameDetailsDto;
import com.casino.rest.api.ws.shared.dto.PlayerDetailsDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {
     List<GameDetailsDto> getLatest10WagerForPlayer(int page, int limit, String emailAddress);

     void savePlayerGames(PlayerDetailsDto playerDetailsDto);
}
