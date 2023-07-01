package com.user.entity;

public class Contact {
	
	private Integer userId;
	private Integer contactId;
	private String email;
	private String contactName;
	
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
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
	@Override
	public String toString() {
		return "Contact [userId=" + userId + ", contactId=" + contactId + ", email=" + email + ", contactName="
				+ contactName + "]";
	}
	
	
	
	
	
	

}
