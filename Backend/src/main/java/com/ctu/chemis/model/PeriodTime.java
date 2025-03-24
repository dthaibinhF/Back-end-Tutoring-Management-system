package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "period_time")
public class PeriodTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "date_of_week", nullable = false, length = 10)
    private String dateOfWeek;

    @Column(name = "start_at", nullable = false)
    private LocalTime startAt;

    @Column(name = "end_at", nullable = false)
    private LocalTime endAt;

    @ManyToMany
    @JoinTable(name = "period_time_class",
            joinColumns = @JoinColumn(name = "period_time_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<Classes> classes;

}