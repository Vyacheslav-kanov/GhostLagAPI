package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.AccountService;
import com.cybersport.tournament_backend.dto.request.ChangePasswordRequest;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.dto.request.UpdateAccountRequest;
import com.cybersport.tournament_backend.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Получить профиль текущего пользователя (просмотр чужого профиля)
    @GetMapping("/profile")
    public ResponseEntity<Account> getProfile() {
        Account account = accountService.getCurrentAccount();
        return ResponseEntity.ok(account);
    }

    // Создать новый аккаунт (регистрация)
    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody CreateAccountRequest request) {
        Account account = accountService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    // Обновить профиль
    @PutMapping("/profile")
    public ResponseEntity<Account> updateProfile(@RequestBody UpdateAccountRequest request) {
        Account account = accountService.updateProfile(request);
        return ResponseEntity.ok(account);
    }

    // Изменить пароль
    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        accountService.changePassword(request);
        return ResponseEntity.ok("Пароль успешно изменён");
    }

    // Удалить аккаунт
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Логин
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody LoginRequest request) {
        Account account = accountService.login(request);
        return ResponseEntity.ok(account);
    }
}
