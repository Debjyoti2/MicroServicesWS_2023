package com.user.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.Contact;

@FeignClient(name="CONTACT-SERVICE")
public interface ContactsFeignService {
	
	@GetMapping("/contacts/getContactsByUserId/{userId}")
	public List<Contact> getContactsByUserId(@PathVariable("userId") Integer userId);

}
