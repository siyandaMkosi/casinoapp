package com.casino.rest.api.ws.io.repository;

import com.casino.rest.api.ws.io.entity.GameEntity;
import com.casino.rest.api.ws.io.entity.PlayerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Long> {
    Page<GameEntity> findTop10ByWagerStatusAndPlayersOrderByDatePlayedDesc(boolean transactionStatus, PlayerEntity player, Pageable pageable);
}
