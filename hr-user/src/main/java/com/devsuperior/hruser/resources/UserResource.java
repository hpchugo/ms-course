package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User User = userRepository.findById(id).get();
		return ResponseEntity.ok(User);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		User User = userRepository.findByEmail(email);
		return ResponseEntity.ok(User);
	}

}
