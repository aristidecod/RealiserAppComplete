package com.ah.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ah.server.dto.UserCardDTO;
import com.ah.server.service.UserCardService;
import com.ah.server.model.UserCard;

import java.util.List;

@RestController
@RequestMapping("/api/usercards")
public class UserCardController {

    @Autowired
    private UserCardService userCardService;

    // Ajouter une carte à un utilisateur
    @PostMapping
    public ResponseEntity<UserCard> addUserCard(@RequestBody UserCardDTO userCardDTO) {
        UserCard.UserCardId userCardId = new UserCard.UserCardId(userCardDTO.getUserId(), userCardDTO.getCardId());
        UserCard newUserCard = userCardService.addUserCard(userCardId, userCardDTO.getQuantity());
        return ResponseEntity.ok(newUserCard);
    }

    // Mettre à jour la quantité d'une carte pour un utilisateur
    @PutMapping("/{userId}/{cardId}")
    public ResponseEntity<UserCard> updateUserCard(@PathVariable Long userId, @PathVariable Long cardId, @RequestParam Integer quantity) {
        UserCard updatedUserCard = userCardService.updateUserCard(userId, cardId, quantity);
        return ResponseEntity.ok(updatedUserCard);
    }

    // Récupérer les cartes d'un utilisateur
    @GetMapping("/{userId}")
    public ResponseEntity<List<UserCard>> getUserCardsByUserId(@PathVariable Long userId) {
        List<UserCard> userCards = userCardService.getUserCardsByUserId(userId);
        return ResponseEntity.ok(userCards);
    }

    // Supprimer une carte spécifique d'un utilisateur
    @DeleteMapping("/{userId}/{cardId}")
    public ResponseEntity<?> deleteUserCard(@PathVariable Long userId, @PathVariable Long cardId) {
        userCardService.deleteUserCard(userId, cardId);
        return ResponseEntity.ok().build();
    }
}

