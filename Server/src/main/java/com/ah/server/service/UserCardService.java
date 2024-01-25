package com.ah.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ah.server.model.UserCard;
import com.ah.server.repository.UserCardRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserCardService {

    @Autowired
    private UserCardRepository userCardRepository;

    // Ajouter une carte à un utilisateur
    public UserCard addUserCard(UserCard.UserCardId userCardId, Integer quantity) {
        UserCard userCard = new UserCard(userCardId, quantity);
        return userCardRepository.save(userCard);
    }

    // Mettre à jour la quantité d'une carte pour un utilisateur
    public UserCard updateUserCard(Long userId, Long cardId, Integer quantity) {
        UserCard userCard = userCardRepository.findById(new UserCard.UserCardId(userId, cardId))
                .orElseThrow(() -> new NoSuchElementException("UserCard not found with userId: " + userId + " and cardId: " + cardId));

        userCard.setQuantity(quantity);
        return userCardRepository.save(userCard);
    }

    // Récupérer les cartes d'un utilisateur
    public List<UserCard> getUserCardsByUserId(Long userId) {
        return userCardRepository.findById_UserId(userId);
    }

    // Supprimer une carte spécifique d'un utilisateur
    public void deleteUserCard(Long userId, Long cardId) {
        userCardRepository.deleteById(new UserCard.UserCardId(userId, cardId));
    }
}

