package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.user.entity.Contact;
import com.user.entity.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	@Override
	public User getUserById(Long userId) {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1211L,"Amit","12345"));
		userList.add(new User(1212L,"Budha","65454"));
		userList.add(new User(1213L,"Dibya","53656"));
		
		
		User user = userList.stream().filter(e->e.getUserId().equals(userId)).findAny().orElse(null);
		
		List<Contact> contacts = this.getContactFromApi(user);
	    user.setContacts(contacts);
	    return user;
		
	}
	
	@HystrixCommand(fallbackMethod = "fallback_getContactFromApi",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="2000")})
	public List<Contact> getContactFromApi(User user){
		@SuppressWarnings("unchecked")
		List<Contact> contacts = this.restTemplate.getForObject("http://CONTACT-SERVICE/contacts/getcontacts/" + user.getUserId(), List.class);
		return contacts;
		
	}
	
	
	public List<Contact> fallback_getContactFromApi() {
		
		Contact c = new Contact();
		c.setContactId(999L);
		c.setContactName("Hysterix DEfault");
		c.setEmail("Hysterix Default Emial");
		c.setUserId(999L);
		List<Contact> contacts = new ArrayList<>();
		contacts.add(c);
		
		return contacts;
	}
}
