package com.cybersport.tournament_backend.dto.responce;

import lombok.Data;

@Data
public class ApiError {
    private int status;
    private String message;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
