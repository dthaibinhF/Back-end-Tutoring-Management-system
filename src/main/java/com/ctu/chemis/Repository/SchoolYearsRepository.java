package com.ctu.chemis.Repository;

import com.ctu.chemis.model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SchoolYearsRepository extends JpaRepository<SchoolYear, Long> {
    @Query("select sy from SchoolYear sy where sy.startAt <= ?1 and sy.endAt >= ?1")
    Optional<SchoolYear> findCurrentSchoolYear(LocalDate currentDate);

}
