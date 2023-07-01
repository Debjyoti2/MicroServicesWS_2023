package com.contact.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contact.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer>{
	
	@Query(value ="select * from t_contacts_microservices",nativeQuery = true)
	public ArrayList<Contact> getContactsByUserId(Integer userId);
}
