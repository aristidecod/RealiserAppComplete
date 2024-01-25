package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.UserCard;
import com.ah.server.model.UserCard.UserCardId;
import java.util.List;

public interface UserCardRepository extends JpaRepository<UserCard, UserCardId> {
    List<UserCard> findById_UserId(Long userId);
    //findByUserId pour obtenir toutes les cartes d'un utilisateur spécifique.
}
