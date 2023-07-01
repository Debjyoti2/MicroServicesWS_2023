package com.contact.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Logger log = LogManager.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/getcontact/{contactId}")
	public Contact getContactsById(@PathVariable("contactId") Integer contactId) {
		log.info("getting getContactsById : " + contactId);
		return contactService.getContactsById(contactId).orElse(new Contact());
	}
	
	@PostMapping("/savesinglecontact")
	public Contact saveSingleContact(@RequestBody Contact contact) {
		log.info("saving  saveSingleContact : " + contact.toString());
		return contactService.saveSingleContact(contact);
	}
	
	@GetMapping("/fetchallContacts")
	public ArrayList<Contact> fetchallContacts(){
		log.info("fetching all contacts");
		return contactService.fetchallContacts();
	}
	
	@GetMapping("/getContactsByUserId/{userId}")
	public ArrayList<Contact> getContactsByUserId(@PathVariable("userId") Integer userId) {
		log.info("getting getContactsById : " + userId);
		return contactService.getContactsByUserId(userId);
	}
	
}
