package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Upcoming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpcomingRepository extends JpaRepository<Upcoming, Long> {
}
