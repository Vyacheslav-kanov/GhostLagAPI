package com.cybersport.tournament_backend.dto.response;

public record ApiError
        (
                int status,
                String message
        ) {}
