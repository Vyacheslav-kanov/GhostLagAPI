package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.AccountPrivateData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountPrivateRepository extends JpaRepository<AccountPrivateData, Long> {

    Optional<AccountPrivateData> findByEmail(String email);

    boolean existsByEmail(String email);
}
