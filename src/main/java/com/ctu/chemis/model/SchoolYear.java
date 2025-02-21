package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "schoolYear",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH})
    private List<Grade> grades;


    //add convenience method for bi-directional relationship

    public void add(Grade tempGrade) {

        //check if list grades exist
        if ((grades == null)) {
            //if dont exist, create new list
            grades = new ArrayList<>();
        }
        //add grade to list
        grades.add(tempGrade);
        //set school year for grade
        tempGrade.setSchoolYear(this);
    }

}
