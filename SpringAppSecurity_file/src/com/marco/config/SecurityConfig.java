package com.marco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public StandardPasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		super.configure(http);
		
		http
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
		.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
		.and()
			.rememberMe()
				.tokenValiditySeconds(86400)
				.userDetailsService(customUserDetailService)
				.key("uniqueAndSecret")
				.rememberMeParameter("remember_me")
		.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/", "/login", "/logout", "/user/**").permitAll()
				.antMatchers("/about", "/admin").authenticated()
				.antMatchers("/admin/**").hasAnyRole("ROOT", "ADMIN")
				.antMatchers("/address/**").hasRole("ADMIN")
				.anyRequest().denyAll()
		.and()
			.csrf().disable();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		super.configure(auth);
		auth.authenticationProvider(customAuthenticationProvider);
	}
}
