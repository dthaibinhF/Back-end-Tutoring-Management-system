package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.AccountDTO;
import com.ctu.chemis.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @RequestMapping("/user")
    public AccountDTO getUserDetailsAfterLogin(Authentication authentication) {
        return accountService.findByEmail(authentication.getName());
    }

}
