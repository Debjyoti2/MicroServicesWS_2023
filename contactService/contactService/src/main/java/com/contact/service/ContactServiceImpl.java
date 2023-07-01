package com.contact.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.dao.ContactRepository;
import com.contact.entity.Contact;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{
	

	@Autowired
	private ContactRepository dao;
	
	@Override
	public Optional<Contact> getContactsById(Integer contactId) {
		return dao.findById(contactId);
	}
	
	@Override
	public Contact saveSingleContact(Contact contact) {
		return dao.save(contact);
	}
	
	@Override
	public ArrayList<Contact> fetchallContacts() {
		return (ArrayList<Contact>) dao.findAll();
	}
	
	@Override
	public ArrayList<Contact> getContactsByUserId(Integer userId) {
		log.info("getContactsByUserId ::::::: ");
		return dao.getContactsByUserId(userId);
	}
	
}
