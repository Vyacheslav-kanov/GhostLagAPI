package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Exception.UserNotFoundException;
import com.cybersport.tournament_backend.Repository.AccountPrivateRepository;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.model.AccountPrivateData;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountPrivateService {

    /**
     * Из Account использует AccountPrivate
     **/

    private final AccountPrivateRepository accountPrivateRepository;

    public AccountPrivateData create(CreateAccountRequest request) {
        String hash = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12));
        AccountPrivateData auth = AccountPrivateData.builder()
                .email(request.getEmail())
                .passwordHash(hash)
                .build();

        return accountPrivateRepository.save(auth);
    }

    public AccountPrivateData authenticate(LoginRequest request) {
        String login = request.getEmail();
        String rawPassword = request.getPassword();

        return accountPrivateRepository
                .findByEmail(login)
                .filter(acc -> BCrypt.checkpw(rawPassword, acc.getPasswordHash()))
                .orElseThrow(() -> new UserNotFoundException(login));
    }

    public boolean emailExists(String email){
        return accountPrivateRepository.existsByEmail(email);
    }

    public AccountPrivateData tryGetByEmail(String email) {
       return accountPrivateRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }
}
