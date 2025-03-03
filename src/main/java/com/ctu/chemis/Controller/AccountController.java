package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.AccountRepository;
import com.ctu.chemis.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RuntimeException("Account not found - " + accountId);
        }
    }

    @GetMapping("/all")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PutMapping("/{accountID}")
    public Account updateAccount(@RequestBody Account account, @PathVariable long accountID) {
        Optional<Account> optAccount = accountRepository.findById(accountID);

        if (optAccount.isPresent()) {
            return accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not found - " + accountID);
        }
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
        } else {
            throw new RuntimeException("Account not found - " + accountId);
        }

    }

}
