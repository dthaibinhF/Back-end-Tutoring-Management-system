package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "grade")
@Getter
@Setter
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id",
//        scope = Grade.class)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "grade")
    private int grade;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "school_year_grade",
            joinColumns = @JoinColumn(name = "grade_id"),
            inverseJoinColumns = @JoinColumn(name = "school_year_id")
    )
    private List<SchoolYear> schoolYears;

}
