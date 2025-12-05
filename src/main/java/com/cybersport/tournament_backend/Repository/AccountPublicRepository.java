package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.AccountPublicData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountPublicRepository extends JpaRepository<AccountPublicData, Long> {

    boolean existsByUsername(String username);
}
