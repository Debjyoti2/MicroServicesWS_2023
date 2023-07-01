package com.user.service;

import java.util.ArrayList;
import java.util.Optional;

import com.user.entity.User;

public interface UserService {
	
	 Optional<User> getUserById(Integer userId);
	 
	 User saveSingleUser(User userobj);
	 
	 ArrayList<User> getallusers();
}
