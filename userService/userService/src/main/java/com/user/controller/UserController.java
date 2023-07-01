package com.user.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController { 
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/getuser/{userId}")
	public User getUserById(@PathVariable("userId")  Integer userid) {
		log.info("going to fetch userinfo with userid :: " + userid);
		return userService.getUserById(userid).orElse(new User());
	}
	
	@PostMapping("/saveSingleUser")
	public User saveSingleUser(@RequestBody User userobj) {
		log.info("saving single user :: " + userobj);
		return userService.saveSingleUser(userobj);
	}
	
	@GetMapping("/getallusers")
	public ArrayList<User> getallusers(){
		log.info("getting all users");
		return userService.getallusers();
		
	}
	
}
