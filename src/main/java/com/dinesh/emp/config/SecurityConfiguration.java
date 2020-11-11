package com.dinesh.emp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dinesh.emp.springsecurity.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
        .authorizeRequests()
       
        .antMatchers("/delete/**").hasAuthority("ROLE_ADMIN")
            .antMatchers(
                    "/registration**",
                    "/js/**",
                    "/css/**",
                    "/img/**",
                    "/webjars/**",
                    "/employeesave/**").permitAll()
            .anyRequest().authenticated()
        .and()
            .formLogin()
                .loginPage("/login")
                    .permitAll()
        .and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
        .permitAll();
}
	
	  @Override
	    public void configure(WebSecurity webSecurity) throws Exception {
		  webSecurity
		   .ignoring()
         .antMatchers("/h2-console/**/**","/employee/fetch");//Should not be in Production!
	  }

@Bean
public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	
}

@Bean
public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordEncoder());
    return auth;
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.authenticationProvider(authenticationProvider());
}
	
}
