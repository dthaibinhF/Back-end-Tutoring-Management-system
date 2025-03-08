package com.ctu.chemis.Controller;


import com.ctu.chemis.DTO.AuthorityDTO;
import com.ctu.chemis.Service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/authority")
public class AuthorityController {
    private final AuthorityService authorityService;

    @GetMapping("/all")
    public List<AuthorityDTO> getAllAuthority() {
        return authorityService.getAllAccountDetails();
    }

    @GetMapping("/{authorityId}")
    public AuthorityDTO getAuthority(@PathVariable long authorityId) {
        return authorityService.getAuthorityBy(authorityId);
    }

    @PutMapping("/{authorityId}")
    public AuthorityDTO updateAuthority(@RequestBody AuthorityDTO authorityDTO, @PathVariable long authorityId) {
        return authorityService.update(authorityDTO, authorityId);
    }

}
