package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.FeedbackService;
import com.cybersport.tournament_backend.model.Feedback;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.findAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id) {
        return feedbackService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Feedback> create(@Valid @RequestBody Feedback body) {
        Feedback created = feedbackService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        feedbackService.delete(id);
    }
}