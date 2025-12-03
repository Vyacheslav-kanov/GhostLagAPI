package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.TournamentRepository;
import com.cybersport.tournament_backend.model.Tournament;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {

    private TournamentRepository tournamentRepository;

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public Tournament findById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found: " + id));
    }

    public Tournament create(Tournament tournament) {
        tournament.setId(null);
        return tournamentRepository.save(tournament);
    }

    public Tournament update(Long id, Tournament updated) {
        Tournament existing = findById(id);
        updated.setId(existing.getId());
        return tournamentRepository.save(updated);
    }

    public void delete(Long id) {
        tournamentRepository.deleteById(id);
    }
}
