package com.mitocode.mitobooks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

	//inyección de dependencia 
		private final UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
                .csrf(AbstractHttpConfigurer::disable)         
                .authorizeHttpRequests(req ->
                                req.requestMatchers("/v1/books/**").permitAll()
                                .anyRequest().authenticated()
                        )
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailsService)
                .build();
	}
	
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	

	//@Bean
    //UserDetailsService users() {
      //  UserDetails user = User.builder()
        //        .username("mito")
          //      .password("{noop}123")
            //    .roles("USER")
               // .build();
      //  return new InMemoryUserDetailsManager(user);
   // }

}
