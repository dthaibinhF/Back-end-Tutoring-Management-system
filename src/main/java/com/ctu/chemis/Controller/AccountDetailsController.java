package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.AccountDetailsRepository;
import com.ctu.chemis.model.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/account-details")
@RequiredArgsConstructor
public class AccountDetailsController {

    private final AccountDetailsRepository accountDetailsRepository;

    @GetMapping("/all")
    public List<AccountDetails> getAllAccountDetails() {
        return accountDetailsRepository.findAll();
    }

    @RequestMapping("/{accountId}")
    public AccountDetails getAccountDetails(@PathVariable long accountId) {
        return accountDetailsRepository.findByAccountId(accountId).orElseThrow(
                () -> new UsernameNotFoundException("user details not found for the user with id: " + accountId)
        );
    }

    @PutMapping("/{accountDetailsId}")
    public AccountDetails updateAccountDetails(@RequestBody AccountDetails accountDetails, @PathVariable long accountDetailsId) {

        Optional<AccountDetails> optAccountDetails = accountDetailsRepository.findById(accountDetailsId);

        if (optAccountDetails.isPresent()) {
            if (accountDetails.getId() == accountDetailsId) {
                return accountDetailsRepository.save(accountDetails);
            } else {
                throw new RuntimeException("Account details id mismatch - " + accountDetailsId);
            }
        } else {
            throw new RuntimeException("Account details not found - " + accountDetailsId);
        }
    }


}
