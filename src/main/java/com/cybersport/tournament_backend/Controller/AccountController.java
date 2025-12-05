package com.cybersport.tournament_backend.Controller;

import com.cybersport.tournament_backend.Service.AccountService;
import com.cybersport.tournament_backend.dto.request.ChangePasswordRequest;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.LoginRequest;
import com.cybersport.tournament_backend.dto.request.UpdateAccountRequest;
import com.cybersport.tournament_backend.dto.response.LoginResponse;
import com.cybersport.tournament_backend.model.Account;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Регистрация",
            description = ""
    )
    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody CreateAccountRequest request) {
        Account account = accountService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @Operation(
            summary = "Сохранить изменения профиля",
            description = ""
    )
    @PutMapping("/profile")
    public ResponseEntity<Account> updateProfile(@RequestBody UpdateAccountRequest request) {
        Account account = accountService.updateProfile(request);
        return ResponseEntity.ok(account);
    }

    @Operation(
            summary = "Изменить пароль",
            description = ""
    )
    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        accountService.changePassword(request);
        return ResponseEntity.ok("Пароль успешно изменён");
    }

    @Operation(
            summary = "Удалить профиль",
            description = "помечает аккаунт удаленным, не удаляет из БД"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Авторизация",
            description =
                    "возвращает JWT токен" +
                    " — это строка из трёх частей (header.payload.signature), закодированных в Base64URL\n" +
                    "JWT указывается для проверки авторизации пользователя в последующих запросах\n" +
                    "Перед каждым запросом к api нужен заголовок: Authorization: Bearer \'токен\'"
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = accountService.login(request);
        return ResponseEntity.ok(response);
    }


}
