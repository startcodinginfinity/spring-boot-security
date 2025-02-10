package com.example.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
		
		return user;
	}

	public HashMap<?,?> AddDataToDatabase(User user) {
		
		HashMap<String,Object> map = new HashMap<>();
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
		
		map.put("statusCode", HttpStatus.CREATED.value());
		
		map.put("message", "Data added to database");
		
		return map;
		
		
	}

	
	

}
