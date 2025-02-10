package com.example.entity;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User implements UserDetails{
	
	@Id
	private String username;

	private String password;
	
	private String role;
	
	private String email;
	
	private String mobileNo;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Stream.of(role).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}
	
	


}
