package com.cybersport.tournament_backend.model;

import lombok.Getter;

@Getter
public enum TournamentStatus {
    REGISTRATION("Регистрация"),
    STARTED("Стартовал"),
    ENDED("Закончен");

    private final String displayName;

    TournamentStatus(String displayName) {
        this.displayName = displayName;
    }
}
