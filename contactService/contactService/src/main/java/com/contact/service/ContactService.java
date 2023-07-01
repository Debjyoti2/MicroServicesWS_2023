package com.contact.service;

import java.util.ArrayList;
import java.util.Optional;

import com.contact.entity.Contact;

public interface ContactService {
	
	Optional<Contact> getContactsById(Integer contactId);
	Contact saveSingleContact(Contact contact);
	ArrayList<Contact> fetchallContacts();
	ArrayList<Contact> getContactsByUserId(Integer userId);

}
