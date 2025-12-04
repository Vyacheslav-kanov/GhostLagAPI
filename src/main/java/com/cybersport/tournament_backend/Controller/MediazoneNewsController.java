package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.MediazoneNewsService;
import com.cybersport.tournament_backend.model.MediazoneNews;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mediazone/news")
public class MediazoneNewsController {

    private MediazoneNewsService mediazoneNewsService;

    @GetMapping
    public ResponseEntity<List<MediazoneNews>> getAll() {
        return ResponseEntity.ok(mediazoneNewsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediazoneNews> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mediazoneNewsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MediazoneNews> create(@RequestBody @Valid MediazoneNews mediazoneNews) {
        MediazoneNews responce = mediazoneNewsService.create(mediazoneNews);
        return ResponseEntity.ok(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediazoneNews> update(@PathVariable Long id, @RequestBody @Valid MediazoneNews mediazoneNews) {
        MediazoneNews responce = mediazoneNewsService.update(id, mediazoneNews);
        return ResponseEntity.ok(responce);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediazoneNewsService.delete(id);
    }
}
