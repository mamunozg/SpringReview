package com.marco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailService customUserDetailService; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		//Datos del formulario de login
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		User userCredentials = (User) customUserDetailService.loadUserByUsername(principal);
		
		if(userCredentials != null) {
			//Comprobación de la contraseña
			if(passwordEncoder.matches(credentials, userCredentials.getPassword())) {				
//				if(credentials.equals(userCredentials.getPassword())) {
				System.out.println("Login Correcto");
				return new UsernamePasswordAuthenticationToken(principal, userCredentials.getPassword(), userCredentials.getAuthorities());
			}
			else {
			System.out.println("Login Incorrecto");
				throw new BadCredentialsException("Error in login");
			}
		}
		else {
			throw new BadCredentialsException("user not found. Error in login");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
