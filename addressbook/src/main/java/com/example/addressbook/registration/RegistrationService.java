package com.example.addressbook.registration;

import com.example.addressbook.appuser.AppUser;
import com.example.addressbook.appuser.AppUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(@Valid @RequestBody RegistrationRequest request){
        boolean isValidEmail =  emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword()
                )
        );
    }
}
