package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.AccountRepository;
import com.ctu.chemis.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Account account) {
        try {
            String hashPwd = passwordEncoder.encode(account.getPassword()); //hashing the password
            account.setPassword(hashPwd); // set pwd as new hashed pwd
            account.setCreateDt(new Date(System.currentTimeMillis())); // set the current date
            Account savedCustomer = accountRepository.save(account); // save the user

            if (savedCustomer.getId() > 0) { // if the id is greater than 0, it means account save successfully
                return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registered failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred: " + e.getMessage());
        }
    }

}
