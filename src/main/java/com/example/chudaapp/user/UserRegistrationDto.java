package com.example.chudaapp.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRegistrationDto {

    @NotEmpty(message = "To pole nie może być puste!")
    private String firstName;

    @NotEmpty(message = "To pole nie może być puste!")
    private String lastName;

    @Email
    @NotEmpty(message = "To pole nie może być puste!")
    private String email;

    @NotEmpty(message = "To pole nie może być puste!")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków!")
    private String password;

    public UserRegistrationDto() {
    }
}
