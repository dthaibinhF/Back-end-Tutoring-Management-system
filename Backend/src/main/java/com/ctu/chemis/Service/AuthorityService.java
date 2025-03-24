package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.AuthorityDTO;
import com.ctu.chemis.Repository.AuthorityRepository;
import com.ctu.chemis.execption.MissMatchException;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.AuthorityMapper;
import com.ctu.chemis.model.Authority;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final AuthorityMapper authorityMapper;

    //GET METHOD
    public AuthorityDTO getAuthorityBy(long authorityId) {
        return authorityMapper.toAuthorityDTO(
                authorityRepository.findById(authorityId).orElseThrow(
                        () -> new NotFoundException("Account Details id not found"))
        );
    }

    public List<AuthorityDTO> getAllAccountDetails() {
        return authorityRepository.findAll()
                .stream().map(authorityMapper::toAuthorityDTO)
                .collect(Collectors.toList());
    }

    //PUT METHOD
    @Transactional
    public AuthorityDTO update(AuthorityDTO authorityDTO, long authorityId) {
        Authority authority = authorityRepository.findById(authorityId).orElseThrow(
                () -> new NotFoundException("Account Details id not found: " + authorityId)
        );

        if (authorityDTO.getId() != authority.getId()) {
            throw new MissMatchException("Account Details id not match: " + authorityId);
        }

        authorityMapper.updateAccountDetailsFromDTO(authority, authorityDTO);
        return authorityMapper.toAuthorityDTO(authority);


    }
}
