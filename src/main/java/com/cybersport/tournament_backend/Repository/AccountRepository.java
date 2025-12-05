package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);
}
