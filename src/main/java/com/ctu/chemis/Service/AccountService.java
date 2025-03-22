package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.AccountDTO;
import com.ctu.chemis.Repository.AccountRepository;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.AccountMapper;
import com.ctu.chemis.model.Account;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    /*Create user
     * @PasswordEncoder
     * */
    public ResponseEntity<String> createAccount(AccountDTO accountDTO) {
        Account account = accountMapper.toAccount(accountDTO);
        try {
            // also just in case they pass an id in JSON ... set id to 0
            // this is to force a save of new item ... instead of update
            account.setId(0);
            //hash password
            String hashPwd = passwordEncoder.encode(account.getPassword());
            //set account password as hashed password
            account.setPassword(hashPwd);
            //set create date
            account.setCreateDt(new Date(System.currentTimeMillis()).toLocalDate());
            Account savedAccount = accountRepository.save(account);

            if (savedAccount.getId() > 0) { // if the id is greater than 0, it means account save successfully
                return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registered failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred: " + e.getMessage());
        }
    }

    //GET METHOD
    public AccountDTO getAccountBy(long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new NotFoundException("Account not found - " + accountId)
        );
        return accountMapper.toAccountDTO(account);
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toAccountDTO)
                .collect(Collectors.toList());
    }

    //PUT METHOD
    @Transactional
    public AccountDTO updateAccount(AccountDTO accountDTO, long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new NotFoundException("Account not found - " + accountId)
        );
        //change the account details with mapper
        accountMapper.updateAccountFromDTO(account, accountDTO);
        //save the updated account, then return with DTO
        return accountMapper.toAccountDTO(accountRepository.save(account));
    }

    //DELETE METHOD
    @Transactional
    public void deleteAccount(long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new NotFoundException("Account not found - " + accountId)
        );
        accountRepository.delete(account);
    }

}
