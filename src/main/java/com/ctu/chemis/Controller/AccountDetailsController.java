package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.AccountDetailsRepository;
import com.ctu.chemis.model.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/account/details")
@RequiredArgsConstructor
public class AccountDetailsController {

    private AccountDetailsRepository accountDetailsRepository;

    @RequestMapping("/all")
    public List<AccountDetails> getAccountDetails() {
        return accountDetailsRepository.findAll();
    }

    @RequestMapping("/{accountId}")
    public AccountDetails getAccountDetails(@PathVariable long accountId) {
        AccountDetails accountDetails = accountDetailsRepository.findByAccountId(accountId).orElseThrow(
                () -> new UsernameNotFoundException("user details not found for the user with id: " + accountId)
        );
        return accountDetails;
    }


}
