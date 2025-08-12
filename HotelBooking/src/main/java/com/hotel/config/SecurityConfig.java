package com.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth
					.requestMatchers("/api/hotels/**","/api/rooms/**").hasRole("ADMIN")
					.requestMatchers("/api/bookings/**").hasAnyRole("USER")
					.requestMatchers("/api/auth/**","/h2-console","/contact","/help").permitAll()
					.anyRequest().authenticated())
					.formLogin(form -> form.permitAll())
					.logout(logout -> logout.permitAll());
					
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetails(){
		UserDetails adminDetails = User.withUsername("Dinga")
									   .password(passwordEncoder().encode("dinga123"))
									   .roles("ADMIN")
									   .build();
		
		UserDetails userDetails = User.withUsername("Mangi")
				   					  .password(passwordEncoder().encode("mangi123"))
//				   				      .password("{noop}mangi123")//no password encoder
				   					  .roles("USER")
				   					  .build();
		return new InMemoryUserDetailsManager(adminDetails,userDetails);
	}
}