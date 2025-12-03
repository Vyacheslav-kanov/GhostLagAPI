package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.ReviewService;
import com.cybersport.tournament_backend.dto.request.CreateReviewRequest;
import com.cybersport.tournament_backend.dto.responce.ReviewResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

//    private final ReviewService reviewService;
//
//    public ReviewController(ReviewService reviewService) {
//        this.reviewService = reviewService;
//    }
//
//    // Получить все отзывы
//    @GetMapping
//    public ResponseEntity<List<ReviewResponse>> getAll() {
//        List<ReviewResponse> reviews = reviewService.getAll();
//        return ResponseEntity.ok(reviews);
//    }
//
//    // Получить отзыв по ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ReviewResponse> getById(@PathVariable Long id) {
//        ReviewResponse review = reviewService.getById(id);
//        return ResponseEntity.ok(review);
//    }
//
//    // Создать новый отзыв
//    @PostMapping
//    public ResponseEntity<ReviewResponse> create(@RequestBody CreateReviewRequest request) {
//        ReviewResponse review = reviewService.create(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(review);
//    }
//
//    // Удалить отзыв
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        reviewService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}

