package com.example.addressbook.contact;

import com.example.addressbook.appuser.AppUser;
import com.example.addressbook.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final AppUserService appUserService;

    public Contact addContact(Contact contact, Long appUserId) {
        AppUser appUser = appUserService.findAppUserById(appUserId);
        if(appUser == null){
            throw new IllegalStateException("User not found");
        }
        contact.setAppUser(appUser);
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(Long appUserId) {
        return contactRepository.findByAppUserId(appUserId);
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public void deleteContact(Long id) {
        Optional<Contact> contactOptional = getContactById(id);
        if (contactOptional.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Contact not found for user");
        }
    }
}
