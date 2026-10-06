package com.lakshmikandan.primepass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String userName;
    String password;
    String email;
    @ColumnDefault(value = "'USER'")
    String role;
    long phoneNo;
}
