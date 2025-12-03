package com.cybersport.tournament_backend.Exception;

public class UsernameAlreadyExistsException extends RuntimeException{

    private final String username;

    public UsernameAlreadyExistsException(String username) {
        super("User with username '" + username + "' already exists");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
