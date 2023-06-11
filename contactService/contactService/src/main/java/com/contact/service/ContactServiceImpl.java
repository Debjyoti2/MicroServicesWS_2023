package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{

	private static Logger log = LogManager.getLogger(ContactServiceImpl.class);
	
	@Override
	public List<Contact> getContactListOfaUser(Long userId) {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact(1211L,1L,"babu@tcs.com","babu"));
		contacts.add(new Contact(1211L,1L,"bittu@tcs.com","bittu"));
		log.fatal("ELK Implementation successfull from CONTACT-SERVICE Microservices");
		return contacts.stream().filter(e->e.getUserId().equals(userId)).collect(Collectors.toList());
	}
}
