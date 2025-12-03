package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Exception.AccountNotFoundOrBadPasswordException;
import com.cybersport.tournament_backend.Exception.UserMailAlreadyExistsException;
import com.cybersport.tournament_backend.Exception.UsernameAlreadyExistsException;
import com.cybersport.tournament_backend.Repository.AccountRepository;
import com.cybersport.tournament_backend.Repository.AuthAccountRepository;
import com.cybersport.tournament_backend.dto.request.ChangePasswordRequest;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.dto.request.UpdateAccountRequest;
import com.cybersport.tournament_backend.model.Account;
import com.cybersport.tournament_backend.model.AuthAccount;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AuthService authService;
    private final AuthAccountRepository authAccountRepository;
    private final AccountRepository accountRepository;


    public Account getCurrentAccount() {
        return null;
    }

    public Account register(CreateAccountRequest request) {
        AuthAccount auth = authService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

        Account account = Account.builder()
                .authAccount(auth)
                .build();

        return accountRepository.save(account);
    }

    public Account updateProfile(UpdateAccountRequest request) {
        return null;
    }

    public void changePassword(ChangePasswordRequest request) {

    }

    public void delete(Long id) {

    }

    public Account login(LoginRequest request) {
        AuthAccount auth = authService.authenticate(request).orElseThrow(() -> new AccountNotFoundOrBadPasswordException());

        Account account = Account.builder()
                .authAccount(auth)
                .build();

        return account;
    }
}
