package com.cybersport.tournament_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountRequest {

//    private Long id;
//
//    private AccountPublic accountPublic;

    private String username;

    private String icon;
}
