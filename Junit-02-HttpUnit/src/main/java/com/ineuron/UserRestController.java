package com.ineuron;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@GetMapping(value = "/get")
	public String get() {
		return "hello";
	}

}
