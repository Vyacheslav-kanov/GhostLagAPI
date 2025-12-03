package com.cybersport.tournament_backend.Repository;

import com.cybersport.tournament_backend.model.Account;
import com.cybersport.tournament_backend.model.AuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAuthAccountId(Long authAccountId);
//    Account save(Account account);
}
