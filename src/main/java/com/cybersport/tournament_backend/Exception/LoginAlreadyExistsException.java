package com.cybersport.tournament_backend.Exception;

public class LoginAlreadyExistsException extends RuntimeException{

    private final String login;

    public LoginAlreadyExistsException(String login) {
        super("User with login " + login + " already exists");
        this.login = login;
    }

    public String getUsername() {
        return login;
    }
}
