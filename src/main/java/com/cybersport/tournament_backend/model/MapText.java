package com.cybersport.tournament_backend.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapText {

    private List<String> teams;

    private List<String> format;

    private List<Maps> maps;
}
