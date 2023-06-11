package com.contact.entity;

public class Contact {
	
	private Long userId;
	private Long contactId;
	private String email;
	private String contactName;
	
	
	public Contact(Long userId, Long contactId, String email, String contactName) {
		super();
		this.userId = userId;
		this.contactId = contactId;
		this.email = email;
		this.contactName = contactName;
	}


	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getContactId() {
		return contactId;
	}


	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) { 
		this.contactName = contactName;
	}
	
	
	

}
