package com.ctu.chemis.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "account")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Account.class)
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

    @OneToOne(cascade = CascadeType.ALL)
    // cascade all because if we delete account, we want to delete account details as well
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

    @Column(name = "created_at")
    private Date createDt;

    @OneToMany(mappedBy = "account",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    private List<Authority> authorities;

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

    //add convince method
    public void add(Authority tempAuthority) {
        if (authorities == null) {
            authorities = new ArrayList<>();
        } else {
            authorities.add(tempAuthority);
        }
        tempAuthority.setAccount(this);
    }

}
