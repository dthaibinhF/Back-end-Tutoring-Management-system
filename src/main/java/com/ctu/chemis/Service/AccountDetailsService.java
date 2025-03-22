package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.AccountDetailsDTO;
import com.ctu.chemis.Repository.AccountDetailsRepository;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.AccountDetailsMapper;
import com.ctu.chemis.model.AccountDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountDetailsService {

    private final AccountDetailsRepository accountDetailsRepository;
    private final AccountDetailsMapper accountDetailsMapper;

    //GET METHOD
    public AccountDetailsDTO getAccountDetailsBy(long accountDetailsId) {
        return accountDetailsMapper.toAccountDetailsDTO(
                accountDetailsRepository.findById(accountDetailsId).orElseThrow(
                        () -> new NotFoundException("Account Details not found"))
        );
    }

    public List<AccountDetailsDTO> getAllAccountDetails() {
        return accountDetailsRepository.findAll()
                .stream().map(accountDetailsMapper::toAccountDetailsDTO)
                .collect(Collectors.toList());
    }

    //PUT METHOD
    @Transactional
    public AccountDetailsDTO update(AccountDetailsDTO accountDetailsDTO, long accountDetailsId) {
        AccountDetails accountDetails = accountDetailsRepository.findById(accountDetailsId).orElseThrow(
                () -> new NotFoundException("Account Details id not found: " + accountDetailsId)
        );

        if (accountDetailsDTO.getId() != accountDetails.getId()) {
            throw new NotFoundException("Account Details id not match: " + accountDetailsId);
        }

        accountDetailsMapper.updateAccountDetailsFromDTO(accountDetails, accountDetailsDTO);
        return accountDetailsMapper.toAccountDetailsDTO(accountDetails);


    }


}
