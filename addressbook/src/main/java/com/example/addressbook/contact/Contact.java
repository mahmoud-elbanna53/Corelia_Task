package com.example.addressbook.contact;

import com.example.addressbook.appuser.AppUser; // Import AppUser
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_sequence"
    )
    private Long id;

    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String lastName;

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})$", message = "Phone number must be in a valid format")
    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid email address")
    private String emailAddress;

    @NotNull(message = "Birthdate cannot be null")
    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress, LocalDate birthdate, AppUser appUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthdate = birthdate;
        this.appUser = appUser;
    }
}
