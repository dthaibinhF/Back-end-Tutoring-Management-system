package com.ctu.chemis.model;


import com.ctu.chemis.Constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "account_type")
    private Role accountType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;



}
