package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.GameSession;
import java.util.List;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    List<GameSession> findByUserId(Long userId);
    //findByUserId pour obtenir toutes les sessions de jeu d'un utilisateur spécifique.
}

