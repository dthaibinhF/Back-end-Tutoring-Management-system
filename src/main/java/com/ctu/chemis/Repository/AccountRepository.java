package com.ctu.chemis.Repository;

import com.ctu.chemis.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(long accountId);
    Optional<Account> findByEmail(String email);
}
