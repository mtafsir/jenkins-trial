package com.Test.demo.user;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class UserRestController {
	//Make a dependency to the bean
		@Autowired
		private userDataService service;
		
		//GET /users
		//retrieveAllUsers
		@GetMapping("/users")
		public List<User> retrieveAllUsers(){
			return service.findAll() ;
			
		}
		
		//GET /users/{id}
		@GetMapping("/users/{id}")
		public User retriveUser(@PathVariable int id) {
			return service.findOne(id);
			
		}
		
		//input - details of users
		//output - CREATED & Return the created URI
		@PostMapping("/users")
		public ResponseEntity<Object> createUser(@RequestBody User user) {
			User savedUser = service.save(user);
			//CREATED
			// /user/4
			
			//ServletUriComponentsBuilder.fromCurrentRequest()
			//return current request (/user)
			
			//.path("//{id}")
			//append id onto it
			
			//.buildAndExpand(savedUser.getId()).toUri();
			//replace {id} savedUser.getId()
			
			//save as URI .toUri()
			
			URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
			
			
			//return status code of created
			//pass in location of created object
			//build() the return type
			return ResponseEntity.created(location).build();
			
		}
		
}
