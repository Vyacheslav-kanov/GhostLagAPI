package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.ReviewService;
import com.cybersport.tournament_backend.model.Review;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Получить все отзывы
    @GetMapping
    public ResponseEntity<List<Review>> getAll() {
        List<Review> reviews = reviewService.findAll();
        return ResponseEntity.ok(reviews);
    }

    // Получить отзыв по ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    // Создать новый отзыв
    @PostMapping
    public ResponseEntity<Review> create(@RequestBody @Valid Review review) {
        Review responce = reviewService.create(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);
    }

    // Удалить отзыв
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}

