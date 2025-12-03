package com.cybersport.tournament_backend.Exception;

public class AccountNotFoundOrBadPasswordException extends RuntimeException {

    public AccountNotFoundOrBadPasswordException() {
        super("аккаунт не найден или неверный пароль");
    }

}
