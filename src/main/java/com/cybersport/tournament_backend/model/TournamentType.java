package com.cybersport.tournament_backend.model;

import lombok.Getter;

@Getter
public enum TournamentType {
    ONLINE("Онлайн"),
    OFFLINE("Офлайн");

    private final String displayName;

    TournamentType(String displayName) {
        this.displayName = displayName;
    }
}
