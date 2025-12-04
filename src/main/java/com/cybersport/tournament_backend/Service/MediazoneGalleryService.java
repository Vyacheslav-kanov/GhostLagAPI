package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.MediazoneGalleryRepository;
import com.cybersport.tournament_backend.model.MediazoneGallery;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediazoneGalleryService {

    private MediazoneGalleryRepository mediazoneGalleryRepository;


    public List<MediazoneGallery> findAll() {
        return mediazoneGalleryRepository.findAll();
    }

    public MediazoneGallery findById(Long id) {
        return mediazoneGalleryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gallery with " + id + " not found"));
    }

    public MediazoneGallery create(MediazoneGallery mediazoneGallery) {
        mediazoneGallery.setId(null);
        return mediazoneGalleryRepository.save(mediazoneGallery);
    }

    public MediazoneGallery update(Long id, MediazoneGallery mediazoneGallery) {
        MediazoneGallery existing = findById(id);
        mediazoneGallery.setId(existing.getId());
        return mediazoneGalleryRepository.save(mediazoneGallery);
    }

    public void delete(Long id) {
        findById(id);
        mediazoneGalleryRepository.deleteById(id);
    }
}
