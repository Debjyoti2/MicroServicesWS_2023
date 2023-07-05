package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDAO;
import com.user.entity.Contact;
import com.user.entity.User;
import com.user.external.ContactsFeignService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private ContactsFeignService feignservice;

	@Override
	@CircuitBreaker(name = "getuserIdCB",fallbackMethod = "getUserById_fallback")
	public Optional<User> getUserById(Integer userId) {
		
		List<Contact> contacts= feignservice.getContactsByUserId(userId);
		
		log.info(contacts.toString());
		
		User user= dao.findById(userId).get();
		if(!contacts.isEmpty()) {
			user.setContacts(contacts);
		}
		return Optional.of(user);
	}

	
	public Optional<User> getUserById_fallback(Integer userId, Exception ex){
		
		User user = new User();
		user.setUserId(-1);
		user.setUserName("Default");
		log.info("Exception Fallback : getUserById_fallback ::  ");
		ex.printStackTrace();
		
		return Optional.of(user);
	}
	
	@Override
	public User saveSingleUser(User userobj) {
		return (User) dao.save(userobj);
	}
	
	
	@Override
	public ArrayList<User> getallusers() {
		return (ArrayList<User>) dao.findAll();
	}

}
