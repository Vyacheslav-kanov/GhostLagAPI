package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.TournamentService;
import com.cybersport.tournament_backend.Service.UpcomingService;
import com.cybersport.tournament_backend.model.Tournament;
import com.cybersport.tournament_backend.model.Upcoming;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home/upcoming")
public class UpcomingController {

    private UpcomingService upcomingService;

    @GetMapping
    public List<Upcoming> getAll() {
        return upcomingService.findAll();
    }

    @GetMapping("/{id}")
    public Upcoming getById(@PathVariable Long id) {
        return upcomingService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Upcoming> create(@RequestBody @Valid Upcoming upcoming) {
        Upcoming responce = upcomingService.create(upcoming);
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Upcoming> update(@PathVariable Long id, @RequestBody @Valid Upcoming upcoming) {
        Upcoming responce = upcomingService.update(id, upcoming);
        return ResponseEntity.status(HttpStatus.OK).body(responce);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        upcomingService.delete(id);
    }
}
