package com.marco.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marco.dao.UserDao;
import com.marco.pojo.User;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();		
		System.out.println("Usuario: " + username);
		User user = userDao.findByUserName(username);
		
		if(user != null) {
			authorities.add(new SimpleGrantedAuthority(user.getPermission()));
			org.springframework.security.core.userdetails.User userCredentials = 
					new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), authorities);
			return userCredentials;
		}
		else {
			throw new UsernameNotFoundException("User Not Found");
		}
			 		
	}

}
