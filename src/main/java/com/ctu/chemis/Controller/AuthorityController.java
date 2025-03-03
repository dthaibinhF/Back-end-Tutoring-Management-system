package com.ctu.chemis.Controller;


import com.ctu.chemis.Repository.AuthorityRepository;
import com.ctu.chemis.model.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/authority")
public class AuthorityController {
    private final AuthorityRepository authorityRepository;

    @GetMapping("/all")
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @GetMapping("/{authorityId}")
    public Authority getAuthority(@PathVariable long authorityId) {
        return authorityRepository.findById(authorityId);
    }

    @PutMapping("/update")
    public Authority updateAuthority(@RequestBody Authority authority) {
        return authorityRepository.save(authority);
    }

}
