package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
