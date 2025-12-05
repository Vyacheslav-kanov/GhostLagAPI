package com.cybersport.tournament_backend.dto.response;

import com.cybersport.tournament_backend.model.Account;

public record LoginResponse
        (
                String token,
                Account account
        ) {}
