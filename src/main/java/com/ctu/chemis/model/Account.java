package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter@Setter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String phoneNumber;

    @Column(name = "pwd")
    private String password;

    @Column(name = "role")
    private String Role;

    @Column(name = "created_at")
    private Date createDt;

}
