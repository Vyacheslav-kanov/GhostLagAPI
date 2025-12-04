package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.InfoRepository;
import com.cybersport.tournament_backend.model.Info;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<Info> findAll() {
        return infoRepository.findAll();
    }

    public Info findById(Long id) {
        return infoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Info not found: " + id));
    }

    public Info create(Info info) {
        info.setId(null);
        return infoRepository.save(info);
    }

    public Info update(Long id, Info info) {
        Info existing = findById(id);

        existing.setDate(info.getDate());
        existing.setTitle(info.getTitle());
        existing.setText(info.getText());
        existing.setFiltres(info.getFiltres());

        return infoRepository.save(existing);
    }

    public void delete(Long id) {
        infoRepository.deleteById(id);
    }
}
