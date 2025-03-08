package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.AccountDTO;
import com.ctu.chemis.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AuthorityMapper.class, AccountDetailsMapper.class})
public interface AccountMapper {
    Account toAccount(AccountDTO accountDTO);

    AccountDTO toAccountDTO(Account account);

    void updateAccountFromDTO(@MappingTarget Account account, AccountDTO accountDTO);
}
