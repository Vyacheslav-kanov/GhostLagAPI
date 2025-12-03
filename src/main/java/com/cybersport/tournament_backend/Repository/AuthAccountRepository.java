package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Account;
import com.cybersport.tournament_backend.model.AuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthAccountRepository extends JpaRepository<AuthAccount, Long> {

    Optional<AuthAccount> findByUsername(String username);

    Optional<AuthAccount> findByEmail(String email);

    Optional<AuthAccount> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsernameOrEmail(String username, String email);
}
