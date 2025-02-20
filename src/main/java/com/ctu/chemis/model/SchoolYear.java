package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Year;

@Entity
@Table(name = "school_year")
@Getter@Setter
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;

    @Column(name = "year_start_at")
    private Year yearStartAt;

    @Column(name = "year_end_at")
    private Year yearEndAt;

}
