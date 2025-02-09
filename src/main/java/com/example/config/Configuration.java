package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	UserDetailsService detailsService() {
		
		UserDetails Manager = User.withUsername("Manager")
				               .password(encoder().encode("Manager"))
				               .build();
		UserDetails employee = User.withUsername("Employee")
				                 .password(encoder().encode("Employee"))
				                 .build();
		
		return new InMemoryUserDetailsManager(Manager,employee);
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
