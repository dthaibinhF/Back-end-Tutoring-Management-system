package com.ctu.chemis.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "class")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "max_student")
    private int maxStudent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade")
    private Grade grade;

    @ManyToMany(mappedBy = "classes",
            fetch = FetchType.LAZY)
    private List<PeriodTime> periodTimes;

    @OneToMany(mappedBy = "classes",
            fetch = FetchType.LAZY)
    private List<Student> students;

}
