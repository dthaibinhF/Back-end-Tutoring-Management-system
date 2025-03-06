package com.ctu.chemis.Repository;

import com.ctu.chemis.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    Optional<Grade> findById(long id);

}
