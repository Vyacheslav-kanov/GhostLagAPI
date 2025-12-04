package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Repository.ReviewRepository;
import com.cybersport.tournament_backend.model.Review;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Review create(Review review) {
        review.setId(null);
        return reviewRepository.save(review);
    }

    public void delete(Long id) {
        findById(id);
        reviewRepository.deleteById(id);
    }
}

