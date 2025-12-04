package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.MediazoneRepository;
import com.cybersport.tournament_backend.model.Mediazone;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediazoneService {

    private MediazoneRepository mediazoneRepository;

    public List<Mediazone> findAll() {
        return mediazoneRepository.findAll();
    }

    public Mediazone findById(Long id) {
        return mediazoneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mediazone with " + id + "not found"));
    }

    public Mediazone create(Mediazone mediazone) {
        mediazone.setId(null);
        return mediazoneRepository.save(mediazone);
    }

    public Mediazone update(Long id, Mediazone mediazone) {
        findById(id);
        mediazone.setId(id);
        return mediazoneRepository.save(mediazone);
    }

    public void delete(Long id) {
        findById(id);
        mediazoneRepository.deleteById(id);
    }
}
