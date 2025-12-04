package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.MediazoneGalleryService;
import com.cybersport.tournament_backend.model.MediazoneGallery;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mediazone/gallery")
public class MediazoneGalleryController {

    private MediazoneGalleryService mediazoneGalleryService;

    @GetMapping
    public ResponseEntity<List<MediazoneGallery>> getAll() {
        return ResponseEntity.ok(mediazoneGalleryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediazoneGallery> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mediazoneGalleryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MediazoneGallery> create(@RequestBody @Valid MediazoneGallery mediazoneGallery) {
        MediazoneGallery responce = mediazoneGalleryService.create(mediazoneGallery);
        return ResponseEntity.ok(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediazoneGallery> update(@PathVariable Long id, @RequestBody @Valid MediazoneGallery mediazoneGallery) {
        MediazoneGallery responce = mediazoneGalleryService.update(id, mediazoneGallery);
        return ResponseEntity.ok(responce);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediazoneGalleryService.delete(id);
    }
}
