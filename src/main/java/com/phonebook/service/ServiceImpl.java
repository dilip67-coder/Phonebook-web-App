package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepo;

@Service
public class ServiceImpl{
	
	@Autowired
	private ContactRepo contactRepo;
	
	public void saveContact(Contact contact) {
		
		contactRepo.save(contact);
	}
	
	public List<Contact> getAllContacts() {
		
		return contactRepo.findAll();
	}
	
	public void deleteContact(int contactId) {
		contactRepo.deleteById(contactId);
	}
	
	public Optional<Contact> getContact(int contactId) {
		
		return contactRepo.findById(contactId); 
	}

}
