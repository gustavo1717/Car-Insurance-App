
package com.synex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	


	@Bean
	public SecurityFilterChain apiFilterChain2(HttpSecurity http) throws Exception {
	    http
	        .apply(MyCustomDsl.customDsl()).flag(true).and()
	        .authorizeRequests()
	            .requestMatchers(new AntPathRequestMatcher("/home/**")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/home")).hasAnyRole("USER", "ADMIN")
	            
	            .requestMatchers(new AntPathRequestMatcher("/admin")).hasAnyAuthority("admin")

	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .defaultSuccessUrl("/home")
	            .permitAll();
	    return http.build();
	}
	
	

	

}
