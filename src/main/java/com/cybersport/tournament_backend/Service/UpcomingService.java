package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.UpcomingRepository;
import com.cybersport.tournament_backend.model.Upcoming;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpcomingService {

    private UpcomingRepository upcomingRepository;

    public List<Upcoming> findAll() {
        return upcomingRepository.findAll();
    }

    public Upcoming findById(Long id) {
        return upcomingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Upcoming with " + id + " not found"));
    }

    public Upcoming create(Upcoming upcoming) {
        upcoming.setId(null);
        return upcomingRepository.save(upcoming);
    }

    public void delete(Long id) {
        findById(id);
        upcomingRepository.deleteById(id);
    }

    public Upcoming update(Long id, Upcoming updated) {
        Upcoming existing = findById(id);
        updated.setId(existing.getId());
        return upcomingRepository.save(updated);
    }
}
