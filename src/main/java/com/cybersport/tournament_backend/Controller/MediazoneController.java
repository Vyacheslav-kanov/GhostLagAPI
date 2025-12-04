package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.MediazoneService;
import com.cybersport.tournament_backend.model.Mediazone;
import com.cybersport.tournament_backend.model.MediazoneNews;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mediazone")
public class MediazoneController {

    private MediazoneService mediazoneService;

    @GetMapping
    public ResponseEntity<List<Mediazone>> getAll() {
        return ResponseEntity.ok(mediazoneService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mediazone> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mediazoneService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Mediazone> create(@RequestBody @Valid Mediazone mediazone) {
        Mediazone responce = mediazoneService.create(mediazone);
        return ResponseEntity.ok(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mediazone> update(@PathVariable Long id, @RequestBody @Valid Mediazone mediazone) {
        Mediazone responce = mediazoneService.update(id, mediazone);
        return ResponseEntity.ok(responce);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediazoneService.delete(id);
    }
}
