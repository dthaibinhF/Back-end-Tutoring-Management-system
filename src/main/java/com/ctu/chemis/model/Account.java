package com.ctu.chemis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    // cascade all because if we delete account, we want to delete account details as well
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

    @Column(name = "created_at")
    private LocalDate createDt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_authority",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Student student;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", accountDetails=" + accountDetails +
                ", createDt=" + createDt +
                ", authorities=" + authorities +
                '}';
    }


}
