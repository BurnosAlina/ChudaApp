package com.example.chudaapp.user;

import com.example.chudaapp.userRole.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserRole role;
}
