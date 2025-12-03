package com.cybersport.tournament_backend.Service;

//import com.cybersport.tournament_backend.Repository.ReviewRepository;
import com.cybersport.tournament_backend.dto.request.CreateReviewRequest;
import com.cybersport.tournament_backend.dto.responce.ReviewResponse;
import com.cybersport.tournament_backend.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

//    private final ReviewRepository repository;
//
//    public ReviewService(ReviewRepository repository) {
//        this.repository = repository;
//    }
//
//    public List<ReviewResponse> getAll() {
//        return repository.findAll().stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    public ReviewResponse getById(Long id) {
//        Review review = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Review not found"));
//        return mapToResponse(review);
//    }
//
//    public ReviewResponse create(CreateReviewRequest request) {
//        Review review = new Review();
//        review.setAuthor(request.getAuthor());
//        review.setText(request.getText());
//        review.setAvatarImage(request.getAvatarImage());
//        review.setRole(request.getRole());
//
//        Review saved = repository.save(review);
//        return mapToResponse(saved);
//    }
//
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }
//
//    private ReviewResponse mapToResponse(Review review) {
//        ReviewResponse response = new ReviewResponse();
//        response.setId(review.getId());
//        response.setAuthor(review.getAuthor());
//        response.setText(review.getText());
//        response.setAvatarImage(review.getAvatarImage());
//        response.setRole(review.getRole().getDisplayName());
//        response.setCreatedAt(review.getCreatedAt());
//        return response;
//    }
}

