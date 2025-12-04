package com.cybersport.tournament_backend.Repository;


import com.cybersport.tournament_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
