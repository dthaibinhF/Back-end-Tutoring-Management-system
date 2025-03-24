package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.AccountDetailsDTO;
import com.ctu.chemis.model.AccountDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountDetailsMapper {
    AccountDetails toAccountDetails(AccountDetailsDTO accountDetailsDTO);

    AccountDetailsDTO toAccountDetailsDTO(AccountDetails accountDetails);

    void updateAccountDetailsFromDTO(@MappingTarget AccountDetails accountDetails, AccountDetailsDTO accountDetailsDTO);
}
