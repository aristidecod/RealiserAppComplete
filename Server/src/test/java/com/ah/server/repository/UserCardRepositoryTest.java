package com.ah.server.repository;

import com.ah.server.model.Rarete;
import com.ah.server.model.Type;
import com.ah.server.model.User;
import com.ah.server.model.UserCard;
import com.ah.server.model.UserCard.UserCardId;
import com.ah.server.model.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class UserCardRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserCardRepository userCardRepository;

    private User user;
    private Card card;

    @BeforeEach
    void setUp() {
        // Création et persistance d'un utilisateur
        user = new User();
        user.setUsername("testUser");
        user.setPasswordHash("testPass");
        entityManager.persist(user);

        // Création et persistance d'une carte
        card = new Card();
        card.setNom("Dragon");
        card.setDescription("Puissante créature volante");
        card.setCoutEnElixir(4);
        card.setDegats(150);
        card.setPointsDeVie(1000);
        card.setRarete(Rarete.RARE);
        card.setType(Type.UNITE);
        entityManager.persist(card);

        // Création et persistance d'une UserCard
        UserCard userCard = new UserCard(new UserCard.UserCardId(user.getId(), card.getId()), 5);
        entityManager.persist(userCard);

        // Flush pour s'assurer que les données sont persistées avant le test
        entityManager.flush();
    }


    @Test
    void whenFindById_UserId_thenReturnUserCards() {
        // Act
        List<UserCard> foundUserCards = userCardRepository.findById_UserId(user.getId());

        // Assert
        Assertions.assertThat(foundUserCards).hasSize(1);
        Assertions.assertThat(foundUserCards.get(0).getId().getUserId()).isEqualTo(user.getId()); // Assurez-vous que les cartes appartiennent à l'utilisateur
        // Ajoutez plus d'assertions si nécessaire
    }
}
