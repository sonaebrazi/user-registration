package com.example.user_registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "username")
    private String userName;

    @Column(nullable = false, name = "password")
    private String passWord;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = true)
    private LocalDateTime lastLogin;

    @Column(nullable = false)
    private String role;
}
