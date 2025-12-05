package com.cybersport.tournament_backend.Service;

import com.cybersport.tournament_backend.Exception.UsernameAlreadyExistsException;
import com.cybersport.tournament_backend.Repository.AccountPublicRepository;
import com.cybersport.tournament_backend.dto.request.CreateAccountRequest;
import com.cybersport.tournament_backend.dto.request.UpdateAccountRequest;
import com.cybersport.tournament_backend.model.AccountPublicData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountPublicService {

    private final AccountPublicRepository accountPublicRepository;

    public AccountPublicData create(CreateAccountRequest request) {
        if (accountPublicRepository.existsByUsername(request.getUsername())){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }

        AccountPublicData account = AccountPublicData.builder()
                .username(request.getUsername())
                .build();

        return accountPublicRepository.save(account);
    }

    public boolean usernameExists(String username){
        return accountPublicRepository.existsByUsername(username);
    }

    public AccountPublicData update(AccountPublicData accountPublicData, UpdateAccountRequest request) {
        accountPublicData.setIcon(request.getIcon());
        accountPublicData.setUsername(request.getUsername());

        return accountPublicData;
    }


}
