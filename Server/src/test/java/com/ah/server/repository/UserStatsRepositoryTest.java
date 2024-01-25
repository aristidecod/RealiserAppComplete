package com.ah.server.repository;

import com.ah.server.model.User;
import com.ah.server.model.UserStats;
import com.ah.server.repository.UserStatsRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserStatsRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserStatsRepository userStatsRepository;

    private User user;

    @BeforeEach
    void setUp() {
        // Créez et persistez un utilisateur
        user = new User();
        user.setUsername("testUser");
        user.setPasswordHash("testPass");
        entityManager.persist(user);

        // Créez et persistez les statistiques pour cet utilisateur
        UserStats userStats = new UserStats();
        userStats.setUser(user); // Définissez l'utilisateur associé aux statistiques
        userStats.setXp(100); // XP de l'utilisateur
        userStats.setLevel(2); // Niveau de l'utilisateur
        userStats.setCoins(500); // Pièces de monnaie de l'utilisateur
        userStats.setGems(20); // Gemmes de l'utilisateur
        entityManager.persist(userStats);

        // Flush pour s'assurer que les données sont persistées avant le test
        entityManager.flush();
    }

    @Test
    void whenFindByUserId_thenReturnUserStats() {
        // Act
        Optional<UserStats> foundUserStats = userStatsRepository.findByUserId(user.getId());

        // Assert
        assertThat(foundUserStats).isPresent();
        assertThat(foundUserStats.get().getUser().getId()).isEqualTo(user.getId());
        assertThat(foundUserStats.get().getXp()).isEqualTo(100);
        assertThat(foundUserStats.get().getLevel()).isEqualTo(2);
        assertThat(foundUserStats.get().getCoins()).isEqualTo(500);
        assertThat(foundUserStats.get().getGems()).isEqualTo(20);
    }
}
