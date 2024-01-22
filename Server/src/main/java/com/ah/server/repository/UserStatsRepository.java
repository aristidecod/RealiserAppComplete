package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.UserStats;
import java.util.Optional;

public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
    Optional<UserStats> findByUserId(Long userId);
    // findByUserId pour obtenir les statistiques d'un utilisateur spécifique.
}

