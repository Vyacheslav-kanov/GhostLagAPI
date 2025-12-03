package com.cybersport.tournament_backend.Exception;

public class UserMailAlreadyExistsException extends RuntimeException{

    private final String mail;

    public UserMailAlreadyExistsException(String mail) {
        super("User with mail '" + mail + "' already exists");
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
