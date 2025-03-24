package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDTO {

    long id;
    String name;
    String email;
    String phoneNumber;
    String password;
    AccountDetailsDTO accountDetails;
    LocalDate createDt;
    List<AuthorityDTO> authorities;
}
