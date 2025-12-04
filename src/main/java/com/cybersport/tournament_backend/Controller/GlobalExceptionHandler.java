package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Exception.AccountNotFoundOrBadPasswordException;
import com.cybersport.tournament_backend.Exception.UserMailAlreadyExistsException;
import com.cybersport.tournament_backend.Exception.UsernameAlreadyExistsException;
import com.cybersport.tournament_backend.dto.responce.ApiError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExists(UsernameAlreadyExistsException ex) {
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UserMailAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExists(UserMailAlreadyExistsException ex) {
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(AccountNotFoundOrBadPasswordException.class)
    public ResponseEntity<ApiError> handleBadAuth(AccountNotFoundOrBadPasswordException ex) {
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> HundleEntityNotFound(EntityNotFoundException ex){
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
