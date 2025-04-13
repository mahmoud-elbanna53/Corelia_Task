package com.example.addressbook.registration;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private final String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private final String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid email address")
    private final String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character")
    private final String password;

}
