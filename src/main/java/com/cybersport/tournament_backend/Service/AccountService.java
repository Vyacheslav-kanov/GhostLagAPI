package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Exception.AccountNotFoundOrBadPasswordException;
import com.cybersport.tournament_backend.Exception.UserMailAlreadyExistsException;
import com.cybersport.tournament_backend.Repository.AccountRepository;
import com.cybersport.tournament_backend.dto.request.ChangePasswordRequest;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.dto.request.UpdateAccountRequest;
import com.cybersport.tournament_backend.dto.response.LoginResponse;
import com.cybersport.tournament_backend.model.Account;
import com.cybersport.tournament_backend.model.AccountPrivateData;
import com.cybersport.tournament_backend.model.AccountPublicData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    /**
     * Центральный сервис для работы с аккаунтом.
     **/

    private final AccountPrivateService accountPrivateService;

    private final AccountPublicService accountPublicService;

    private final AccountRepository accountRepository;

    private final JwtService jwtService;


    public Account register(CreateAccountRequest request) {
        if(accountPrivateService.emailExists(request.getEmail())){
            throw new UserMailAlreadyExistsException(request.getEmail());
        }

//        if(accountPublicService.usernameExists(request.getUsername())){
//            throw new UserMailAlreadyExistsException(request.getUsername());
//        }

        AccountPublicData accountPublicData = accountPublicService.create(request);
        AccountPrivateData accountPrivateData = accountPrivateService.create(request);

        Account account = Account.builder()
                .id(null)
                .accountPrivateData(accountPrivateData)
                .accountPublicData(accountPublicData)
                .isDeleted(false)
                .build();

        account.getAccountPrivateData().setAccount(account);
        return accountRepository.save(account);
    }

    public Account updateProfile(UpdateAccountRequest request) {
        Account account = getCurrentAccount();

        accountPublicService.update(account.getAccountPublicData(), request);

        return accountRepository.save(account);
    }

    public void changePassword(ChangePasswordRequest request) {

    }

    public void delete(Long id) {

    }

    public LoginResponse login(LoginRequest request) {
        AccountPrivateData priv = accountPrivateService.authenticate(request);
        Account account = priv.getAccount();
        String token = jwtService.generateToken(priv.getEmail());

        return new LoginResponse(token, account);
    }

    private Account getCurrentAccount() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }

        String email = auth.getName();

        AccountPrivateData priv = accountPrivateService.tryGetByEmail(email);

        return accountRepository.findById(priv.getId())
                .orElseThrow(() -> new IllegalStateException("Account not found"));
    }
}
