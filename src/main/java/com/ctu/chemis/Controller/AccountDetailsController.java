package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.AccountDetailsDTO;
import com.ctu.chemis.Service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(Path.prefix + "/account-details")
@RequiredArgsConstructor
public class AccountDetailsController {

    private final AccountDetailsService accountDetailsService;

    @GetMapping("/all")
    public List<AccountDetailsDTO> getAllAccountDetails() {
        return accountDetailsService.getAllAccountDetails();
    }

    @RequestMapping("/{accountDetailsId}")
    public AccountDetailsDTO getAccountDetailsDetails(@PathVariable long accountDetailsId) {
        return accountDetailsService.getAccountDetailsBy(accountDetailsId);
    }

    @PutMapping("/{accountDetailsId}")
    public AccountDetailsDTO updateAccountDetails(@RequestBody AccountDetailsDTO accountDetailsDTO, @PathVariable long accountDetailsId) {
        return accountDetailsService.update(accountDetailsDTO, accountDetailsId);
    }


}
