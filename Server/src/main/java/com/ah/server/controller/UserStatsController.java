package com.ah.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ah.server.service.UserStatsService;
import com.ah.server.model.UserStats;

@RestController
@RequestMapping("/api/userstats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    // Récupérer les statistiques d'un utilisateur
    @GetMapping("/{userId}")
    public ResponseEntity<UserStats> getUserStatsByUserId(@PathVariable Long userId) {
        return userStatsService.getUserStatsByUserId(userId)
                .map(userStats -> ResponseEntity.ok(userStats))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Mettre à jour les statistiques d'un utilisateur
    @PutMapping("/{userId}")
    public ResponseEntity<UserStats> updateUserStats(@PathVariable Long userId, @RequestBody UserStats statsDetails) {
        UserStats updatedUserStats = userStatsService.updateUserStats(userId, statsDetails);
        return ResponseEntity.ok(updatedUserStats);
    }

    // Ajouter de l'expérience (XP) à un utilisateur
    @PostMapping("/{userId}/addxp")
    public ResponseEntity<UserStats> addExperience(@PathVariable Long userId, @RequestParam int xpToAdd) {
        UserStats updatedUserStats = userStatsService.addExperience(userId, xpToAdd);
        return ResponseEntity.ok(updatedUserStats);
    }

    // Ajouter des pièces (coins) à un utilisateur
    @PostMapping("/{userId}/addcoins")
    public ResponseEntity<UserStats> addCoins(@PathVariable Long userId, @RequestParam int coinsToAdd) {
        UserStats updatedUserStats = userStatsService.addCoins(userId, coinsToAdd);
        return ResponseEntity.ok(updatedUserStats);
    }

    // Ajouter des gemmes (gems) à un utilisateur
    @PostMapping("/{userId}/addgems")
    public ResponseEntity<UserStats> addGems(@PathVariable Long userId, @RequestParam int gemsToAdd) {
        UserStats updatedUserStats = userStatsService.addGems(userId, gemsToAdd);
        return ResponseEntity.ok(updatedUserStats);
    }

    @PostMapping("/{userId}/removexp")
    public ResponseEntity<UserStats> removeExperience(@PathVariable Long userId, @RequestParam int xpToRemove) {
        UserStats updatedUserStats = userStatsService.removeExperience(userId, xpToRemove);
        return ResponseEntity.ok(updatedUserStats);
    }

    // Retirer des pièces (coins) à un utilisateur
    @PostMapping("/{userId}/removecoins")
    public ResponseEntity<UserStats> removeCoins(@PathVariable Long userId, @RequestParam int coinsToRemove) {
        UserStats updatedUserStats = userStatsService.removeCoins(userId, coinsToRemove);
        return ResponseEntity.ok(updatedUserStats);
    }

    // Retirer des gemmes (gems) à un utilisateur
    @PostMapping("/{userId}/removegems")
    public ResponseEntity<UserStats> removeGems(@PathVariable Long userId, @RequestParam int gemsToRemove) {
        UserStats updatedUserStats = userStatsService.removeGems(userId, gemsToRemove);
        return ResponseEntity.ok(updatedUserStats);
    }
}

