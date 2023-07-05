package com.testSleuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SleuthTestController {

	@GetMapping("/testsleuth")
	public String testSleuth() {
		log.info("calling SleuthTestController - testSleuth");
		return "Success";
	}
	
}