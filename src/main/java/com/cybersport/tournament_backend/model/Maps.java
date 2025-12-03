package com.cybersport.tournament_backend.model;

public enum Maps {
    MIRAGE("Mirage"),
    INFERNO("Inferno"),
    OVERPASS("Overpass"),
    NUKE("Nuke"),
    VERTIGO("Vertigo");

    private String displayName;

    Maps(String displayName) {
        this.displayName = displayName;
    }
}
