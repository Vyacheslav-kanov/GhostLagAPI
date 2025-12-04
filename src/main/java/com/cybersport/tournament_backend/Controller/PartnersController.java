package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.PartnersService;
import com.cybersport.tournament_backend.model.Partners;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home/partners")
public class PartnersController {

    private final PartnersService partnersService;

    public PartnersController(PartnersService partnersService) {
        this.partnersService = partnersService;
    }

    @GetMapping
    public List<Partners> getAll() {
        return partnersService.findAll();
    }

    @GetMapping("/{id}")
    public Partners getById(@PathVariable Long id) {
        return partnersService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Partners> create(@Valid @RequestBody Partners body) {
        Partners created = partnersService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public Partners update(@PathVariable Long id, @Valid @RequestBody Partners body) {
        return partnersService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        partnersService.delete(id);
    }
}
