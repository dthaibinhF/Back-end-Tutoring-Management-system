package com.ctu.chemis.config;

import com.ctu.chemis.Repository.AccountRepository;
import com.ctu.chemis.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service /*during start up, spring will create a bean of this class since it implementing the UserDetails class*/
@RequiredArgsConstructor /*Lombok create a constructor with required field --> don't have to mention @Autorwired*/
public class ChemisUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username) //found account with username given,{email}
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username) //throw exception if not found
                );
        List<GrantedAuthority> authorities = account.getAuthorities().stream().map(
                        authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList()
                );
        return new User(account.getEmail(), account.getPassword(), authorities); //return UserDetails object
    }
}
