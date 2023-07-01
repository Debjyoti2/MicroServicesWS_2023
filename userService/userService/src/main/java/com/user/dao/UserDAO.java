package com.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.user.entity.User;

public interface UserDAO extends CrudRepository<User,Integer>{
	
}
