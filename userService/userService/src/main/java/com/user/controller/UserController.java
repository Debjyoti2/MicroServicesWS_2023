package com.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController { 
	
    private static Logger log = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/getuser/{userId}")
	public User getUserById(@PathVariable("userId")  Long userid) {
		log.info("going to fetch userinfo with userid :: " + userid);
		log.fatal("ELK Implementation successfull from USER-SERVICE Microservices");
		return userService.getUserById(userid);
		
		
	}
	
}
