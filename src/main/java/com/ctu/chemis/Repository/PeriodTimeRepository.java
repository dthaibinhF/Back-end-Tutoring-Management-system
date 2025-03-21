package com.ctu.chemis.Repository;

import com.ctu.chemis.model.PeriodTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodTimeRepository extends JpaRepository<PeriodTime, Long> {

}
