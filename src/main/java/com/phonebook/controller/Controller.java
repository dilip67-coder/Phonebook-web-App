package com.phonebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.model.Contact;
import com.phonebook.service.ServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private ServiceImpl service;
	
	@GetMapping("/")
	public String welcomeMsg() {
		
		return "Welcome To PhoneBook";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@RequestBody Contact contact) {
		System.out.println("Contact ; "+contact);
		service.saveContact(contact);
		
		return "contact Saved";
	}
	
	
	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		
		return service.getAllContacts();
	}
	
	@GetMapping("/getContact/{contactId}")
	public Optional<Contact> getContactById(@PathVariable int contactId) {
		
		return service.getContact(contactId);
	}
	
	@DeleteMapping("/deleteContact/{contactId}")
	public String deleteContact(@PathVariable int contactId) {
		
		service.deleteContact(contactId);
		
		return "Contact Deleted ****";
	}

}
