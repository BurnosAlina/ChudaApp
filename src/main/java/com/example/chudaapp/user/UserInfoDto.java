package com.example.chudaapp.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roleName;

}
