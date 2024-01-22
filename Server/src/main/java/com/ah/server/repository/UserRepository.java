package com.ah.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ah.server.model.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //findByUsername retournerait un utilisateur spécifique par son nom d'utilisateur
    void deleteByUsername(String username);
    //deleteByUsername supprime un utilisateur a partir de son nom d'utilisateur
}

