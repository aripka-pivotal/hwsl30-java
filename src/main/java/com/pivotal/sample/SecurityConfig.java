package com.pivotal.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and().withUser("user2").password("pw2").roles("USER","USER2");
    }
	
	
    @Override
	public void configure(HttpSecurity httpSecurity)throws Exception{
		httpSecurity.authorizeRequests().regexMatchers("/admin").hasRole("USER").and().formLogin().and().logout().logoutSuccessUrl("/hello");
		
		//anyRequest().authenticated().and().httpBasic();
		
	}
}
