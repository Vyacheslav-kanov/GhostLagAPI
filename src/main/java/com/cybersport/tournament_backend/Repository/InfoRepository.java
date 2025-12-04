package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
