package com.example.addressbook.appuser;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;

//    @NotBlank(message = "First Name cannot be blank")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String firstName;

//    @NotBlank(message = "Second Name cannot be blank")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String lastName;

//    @NotBlank(message = "Email cannot be blank")
//    @Email(message = "Email must be a valid email address")
    private String email;

//    @NotBlank(message = "Password cannot be blank")
//    @Size(min = 8, message = "Password must be at least 8 characters long")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
//            message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    public AppUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
