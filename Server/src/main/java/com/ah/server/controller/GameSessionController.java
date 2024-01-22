package com.ah.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ah.server.service.GameSessionService;
import com.ah.server.model.GameSession;

import java.util.List;

@RestController
@RequestMapping("/api/gamesessions")
public class GameSessionController {

    @Autowired
    private GameSessionService gameSessionService;

    // Démarrer une nouvelle session de jeu
    @PostMapping("/start")
    public ResponseEntity<GameSession> startNewGameSession(@RequestParam Long userId) {
        GameSession newSession = gameSessionService.startNewGameSession(userId);
        return ResponseEntity.ok(newSession);
    }


    // Terminer une session de jeu
    @PutMapping("/end/{sessionId}")
    public ResponseEntity<GameSession> endGameSession(@PathVariable Long sessionId) {
        GameSession endedSession = gameSessionService.endGameSession(sessionId);
        return ResponseEntity.ok(endedSession);
    }

    // Récupérer toutes les sessions de jeu pour un utilisateur spécifique
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GameSession>> getGameSessionsByUserId(@PathVariable Long userId) {
        List<GameSession> sessions = gameSessionService.getGameSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    // Récupérer une session de jeu spécifique par son ID
    @GetMapping("/{sessionId}")
    public ResponseEntity<GameSession> getGameSessionById(@PathVariable Long sessionId) {
        GameSession session = gameSessionService.getGameSessionById(sessionId);
        return ResponseEntity.ok(session);
    }

    // Supprimer une session de jeu
    @DeleteMapping("/{sessionId}")
    public ResponseEntity<?> deleteGameSession(@PathVariable Long sessionId) {
        gameSessionService.deleteGameSession(sessionId);
        return ResponseEntity.ok().build();
    }
}
