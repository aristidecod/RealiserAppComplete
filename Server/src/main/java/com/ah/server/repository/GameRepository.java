package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
