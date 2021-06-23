package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {

		builder.inMemoryAuthentication().withUser("bhagwan").password("bhagwan").roles("USER")
		.and().withUser("singh").password("singh").roles("ADMIN");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
		
		http.authorizeRequests().
		 antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}

}
