package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.AccountDTO;
import com.ctu.chemis.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable long accountId) {
        return ResponseEntity.ok(accountService.getAccountBy(accountId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/{accountID}")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable long accountID) {
        return ResponseEntity.ok(accountService.updateAccount(accountDTO, accountID));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable long accountId) {
        AccountDTO accountDTO = accountService.getAccountBy(accountId);
        if (accountDTO != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account id: " + accountId + " not found");
        } else {
            accountService.deleteAccount(accountId);
            return ResponseEntity.status(HttpStatus.OK).body("Account with id: " + accountId + " deleted successfully");

        }
    }

}
