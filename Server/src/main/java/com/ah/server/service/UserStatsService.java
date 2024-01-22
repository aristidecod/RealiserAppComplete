package com.ah.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ah.server.model.UserStats;
import com.ah.server.repository.UserStatsRepository;

import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class UserStatsService {

    @Autowired
    private UserStatsRepository userStatsRepository;

    // Récupérer les statistiques d'un utilisateur
    public Optional<UserStats> getUserStatsByUserId(Long userId) {
        return userStatsRepository.findByUserId(userId);
    }

    // Mettre à jour les statistiques d'un utilisateur
    public UserStats updateUserStats(Long userId, UserStats statsDetails) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        userStats.setXp(statsDetails.getXp());
        userStats.setLevel(statsDetails.getLevel());
        userStats.setCoins(statsDetails.getCoins());
        userStats.setGems(statsDetails.getGems());

        return userStatsRepository.save(userStats);
    }

    // Ajouter de l'expérience (XP) à un utilisateur
    public UserStats addExperience(Long userId, int xpToAdd) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        userStats.setXp(userStats.getXp() + xpToAdd);
        return userStatsRepository.save(userStats);
    }

    // Ajouter des pièces (coins) à un utilisateur
    public UserStats addCoins(Long userId, int coinsToAdd) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        userStats.setCoins(userStats.getCoins() + coinsToAdd);
        return userStatsRepository.save(userStats);
    }

    // Ajouter des gemmes (gems) à un utilisateur
    public UserStats addGems(Long userId, int gemsToAdd) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        userStats.setGems(userStats.getGems() + gemsToAdd);
        return userStatsRepository.save(userStats);
    }
    public UserStats removeExperience(Long userId, int xpToRemove) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        int updatedXp = Math.max(userStats.getXp() - xpToRemove, 0);  // Assurez-vous que l'XP ne devient pas négative
        userStats.setXp(updatedXp);
        return userStatsRepository.save(userStats);
    }

    // Retirer des pièces (coins) à un utilisateur
    public UserStats removeCoins(Long userId, int coinsToRemove) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        int updatedCoins = Math.max(userStats.getCoins() - coinsToRemove, 0);  // Assurez-vous que les coins ne deviennent pas négatifs
        userStats.setCoins(updatedCoins);
        return userStatsRepository.save(userStats);
    }

    // Retirer des gemmes (gems) à un utilisateur
    public UserStats removeGems(Long userId, int gemsToRemove) {
        UserStats userStats = userStatsRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStats not found for user id: " + userId));

        int updatedGems = Math.max(userStats.getGems() - gemsToRemove, 0);  // Assurez-vous que les gemmes ne deviennent pas négatives
        userStats.setGems(updatedGems);
        return userStatsRepository.save(userStats);
    }
}
