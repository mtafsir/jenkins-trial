package com.Test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

	@GetMapping("/user")
	public String Helloworld() {
		
		return "Hello World";
		
	}
	
}
