package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.TournamentService;
import com.cybersport.tournament_backend.model.Tournament;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getAll() {
        return tournamentService.findAll();
    }

    @GetMapping("/{id}")
    public Tournament getById(@PathVariable Long id) {
        return tournamentService.findById(id);
    }

    @PostMapping
    public Tournament create(@RequestBody @Valid Tournament tournament) {
        return tournamentService.create(tournament);
    }

    @PutMapping("/{id}")
    public Tournament update(@PathVariable Long id, @RequestBody @Valid Tournament tournament) {
        return tournamentService.update(id, tournament);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tournamentService.delete(id);
    }
}
