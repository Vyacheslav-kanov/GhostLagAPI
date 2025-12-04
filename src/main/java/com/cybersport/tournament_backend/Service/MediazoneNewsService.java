package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.MediazoneNewsRepository;
import com.cybersport.tournament_backend.model.MediazoneNews;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediazoneNewsService {

    private MediazoneNewsRepository mediazoneNewsRepository;


    public List<MediazoneNews> findAll() {
        return mediazoneNewsRepository.findAll();
    }

    public MediazoneNews findById(Long id) {
        return mediazoneNewsRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MediazoneNews with " + id + " not found"));
    }

    public MediazoneNews create(MediazoneNews mediazoneNews) {
        mediazoneNews.setId(null);
        return mediazoneNewsRepository.save(mediazoneNews);
    }

    public MediazoneNews update(Long id, MediazoneNews mediazoneNews) {
        MediazoneNews existing = findById(id);
        mediazoneNews.setId(existing.getId());
        return mediazoneNewsRepository.save(mediazoneNews);
    }

    public void delete(Long id) {
        findById(id);
        mediazoneNewsRepository.deleteById(id);
    }
}
