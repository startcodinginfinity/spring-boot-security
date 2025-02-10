package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.service.UserService;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {
	
//	@Bean
//	UserDetailsService detailsService() {
//		
//		UserDetails Manager = User.withUsername("Manager")
//				               .password(encoder().encode("Manager"))
//				               .build();
//		UserDetails employee = User.withUsername("Employee")
//				                 .password(encoder().encode("Employee"))
//				                 .build();
//		
//		return new InMemoryUserDetailsManager(Manager,employee);
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		
		
	return httpSecurity.csrf(csrf->csrf.disable())
			           .authorizeHttpRequests(auth->auth.requestMatchers("/api/v1/add").permitAll()
			           .anyRequest().authenticated())
			           .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			           .build();
			           
		
	}
	
	
	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		
//	
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		
//		authenticationProvider.setUserDetailsService(new UserService());
//				
//		authenticationProvider.setPasswordEncoder(encoder());
//		
//		return authenticationProvider;
//		
//	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
