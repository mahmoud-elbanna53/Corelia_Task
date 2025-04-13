package com.example.addressbook.contact;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact, @RequestParam Long appUserId) {
        Contact createdContact = contactService.addContact(contact, appUserId);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(@RequestParam Long appUserId) {
        List<Contact> contacts = contactService.getAllContacts(appUserId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
