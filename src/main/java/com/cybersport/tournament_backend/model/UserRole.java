package com.cybersport.tournament_backend.model;

import lombok.Getter;

@Getter
public enum UserRole {

    PARTICIPANT("Участник"),
    ORGANIZER("Организатор"),
    ADMIN("Администратор");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }
}
