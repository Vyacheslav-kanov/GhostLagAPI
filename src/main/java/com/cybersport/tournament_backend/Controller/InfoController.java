package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.InfoService;
import com.cybersport.tournament_backend.model.Info;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home/info")
public class InfoController {

    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public List<Info> getAll() {
        return infoService.findAll();
    }

    @GetMapping("/{id}")
    public Info getById(@PathVariable Long id) {
        return infoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Info> create(@Valid @RequestBody Info body) {
        Info created = infoService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public Info update(@PathVariable Long id, @Valid @RequestBody Info body) {
        return infoService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        infoService.delete(id);
    }
}
