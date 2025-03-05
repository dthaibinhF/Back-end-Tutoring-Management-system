package com.ctu.chemis.Repository;

import com.ctu.chemis.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findById(long accountDetailsId);
    Optional<AccountDetails> findByAccountId(long accountId);
}
