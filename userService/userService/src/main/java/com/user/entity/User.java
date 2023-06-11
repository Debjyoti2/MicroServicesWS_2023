package com.user.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Long userId;
	
	private String userName;
	private String phone;
	private List<Contact> contacts = new ArrayList<>();
	
	
	public User(Long userId, String userName, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
	}


	public User(Long userId, String userName, String phone, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.contacts = contacts;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	

}
