package com.example.addressbook.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ContactRepository extends JpaRepository<Contact, Long>{
    List<Contact> findByAppUserId(Long appUserId); // Find contacts by user ID
}
