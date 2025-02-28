package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.AccountRepository;
import com.ctu.chemis.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable long accountId) {
        return accountRepository.findById(accountId);
    }

    @GetMapping("/all")
    public List<Account> getAccounts() {
        System.out.println("start");
        System.out.println(accountRepository.findAll());
        return accountRepository.findAll();
    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable long accountId) {
        Account account = accountRepository.findById(accountId);

        // throw exception if null

        if (account == null) {
            throw new RuntimeException("Employee id not found - " + accountId);
        }

        accountRepository.delete(account);
    }

}
