package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public String hello() {
		System.out.println("hi");
		return "Hello world";
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> AddDataToDatabase(@RequestBody User user){
		
		var result = userService.AddDataToDatabase(user);
		
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}

}
