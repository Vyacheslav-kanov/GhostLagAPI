package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.PartnersRepository;
import com.cybersport.tournament_backend.model.Partners;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnersService {

    private PartnersRepository partnersRepository;

    public PartnersService(PartnersRepository partnersRepository) {
        this.partnersRepository = partnersRepository;
    }

    public List<Partners> findAll() {
        return partnersRepository.findAll();
    }

    public Partners findById(Long id) {
        return partnersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Partner not found: " + id));
    }

    public Partners create(Partners partner) {
        partner.setId(null);
        return partnersRepository.save(partner);
    }

    public Partners update(Long id, Partners partner) {
        Partners existing = findById(id);

        existing.setTitle(partner.getTitle());
        existing.setDescription(partner.getDescription());
        existing.setIcon(partner.getIcon());

        return partnersRepository.save(existing);
    }

    public void delete(Long id) {
        partnersRepository.deleteById(id);
    }
}
