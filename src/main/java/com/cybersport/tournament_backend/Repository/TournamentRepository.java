package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
