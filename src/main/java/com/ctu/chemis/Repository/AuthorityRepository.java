package com.ctu.chemis.Repository;

import com.ctu.chemis.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findById(long authorityId);
    Optional<Authority> findByAccountId(long account_id);
}
