package com.casino.rest.api.ws.io.repository;

import com.casino.rest.api.ws.io.entity.PlayerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
    PlayerEntity findDistinctByEmailAddress(String emailAddress);
}

