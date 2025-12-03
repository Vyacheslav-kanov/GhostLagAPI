package com.cybersport.tournament_backend.dto.responce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponse {
    private Long id;
    private String author;
    private String text;
    private Integer rating;
    private String avatarImage;
    private String role;
    private LocalDateTime createdAt;
}
