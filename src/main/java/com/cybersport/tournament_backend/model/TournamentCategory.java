package com.cybersport.tournament_backend.model;

public enum TournamentCategory {
    PREMIUM("premium"),
    STANDARD("standard"),
    AMATEUR("amateur");

    private final String value;

    TournamentCategory(String value) {
        this.value = value;
    }
}
