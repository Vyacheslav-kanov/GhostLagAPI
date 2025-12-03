package com.cybersport.tournament_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountRequest {
    private String username;
    private String email;
    private String profileImage;
}
