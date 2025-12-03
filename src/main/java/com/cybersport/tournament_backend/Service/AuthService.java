package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Exception.UserMailAlreadyExistsException;
import com.cybersport.tournament_backend.Exception.UsernameAlreadyExistsException;
import com.cybersport.tournament_backend.Repository.AuthAccountRepository;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.model.AuthAccount;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {



    private final AuthAccountRepository authAccountRepository;

    public AuthAccount register(String username, String email, String rawPassword) {
        if (authAccountRepository.existsByUsername(username)){
            throw new UsernameAlreadyExistsException(username);
        }

        if(authAccountRepository.existsByEmail(email)){
            throw new UserMailAlreadyExistsException(email);
        }

        String hash = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));

        AuthAccount auth = AuthAccount.builder()
                .username(username)
                .email(email)
                .passwordHash(hash)
                .build();

        return authAccountRepository.save(auth);
    }

    public AuthAccount register(CreateAccountRequest request) { //перегрузка
        if (authAccountRepository.existsByUsername(request.getUsername())){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }

        if(authAccountRepository.existsByEmail(request.getEmail())){
            throw new UserMailAlreadyExistsException(request.getEmail());
        }

        String hash = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12));
        AuthAccount auth = AuthAccount.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(hash)
                .build();

        return authAccountRepository.save(auth);
    }

    public Optional<AuthAccount> authenticate(LoginRequest request) {
        String login = request.getLogin();
        String rawPassword = request.getPassword();

        return authAccountRepository
                .findByUsernameOrEmail(login, login)
                .filter(acc -> BCrypt.checkpw(rawPassword, acc.getPasswordHash()));
    }
}
