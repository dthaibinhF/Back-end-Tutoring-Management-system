package com.ctu.chemis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "school_year")
@Getter
@Setter
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_at")
    private LocalDate startAt;

    @Column(name = "end_at")
    private LocalDate endAt;

    @Column(name = "year_start_at")
    private Integer yearStartAt;

    @Column(name = "year_end_at")
    private Integer yearEndAt;

    @ManyToMany(mappedBy = "schoolYears",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Grade> grades;

}
