package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.AuthorityDTO;
import com.ctu.chemis.model.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface AuthorityMapper {
    Authority toAuthority(AuthorityDTO authorityDTO);

    AuthorityDTO toAuthorityDTO(Authority authority);

    void updateAccountDetailsFromDTO(@MappingTarget Authority authority, AuthorityDTO authorityDTO);
}
