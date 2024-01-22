package com.ah.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ah.server.model.GameSession;
import com.ah.server.model.User;
import com.ah.server.repository.GameSessionRepository;
import com.ah.server.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameSessionService {

    @Autowired
    private GameSessionRepository gameSessionRepository;
    private  UserRepository userRepository;

    // Démarrer une nouvelle session de jeu
    public GameSession startNewGameSession(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        GameSession newSession = new GameSession();
        newSession.setUser(user);
        newSession.setStartTime(new Timestamp(System.currentTimeMillis()));
        return gameSessionRepository.save(newSession);
    }


    // Terminer une session de jeu
    public GameSession endGameSession(Long sessionId) {
        GameSession session = gameSessionRepository.findById(sessionId)
                .orElseThrow(() -> new NoSuchElementException("Game session not found with id: " + sessionId));

        session.setEndTime(new Timestamp(System.currentTimeMillis()));
        return gameSessionRepository.save(session);
    }

    // Récupérer toutes les sessions de jeu pour un utilisateur spécifique
    public List<GameSession> getGameSessionsByUserId(Long userId) {
        return gameSessionRepository.findByUserId(userId);
    }

    // Récupérer une session de jeu spécifique par son ID
    public GameSession getGameSessionById(Long sessionId) {
        return gameSessionRepository.findById(sessionId)
                .orElseThrow(() -> new NoSuchElementException("Game session not found with id: " + sessionId));
    }

    // Supprimer une session de jeu
    public void deleteGameSession(Long sessionId) {
        gameSessionRepository.deleteById(sessionId);
    }
}

