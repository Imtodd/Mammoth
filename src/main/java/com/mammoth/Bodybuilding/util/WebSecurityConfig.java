package com.mammoth.Bodybuilding.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mammoth.Bodybuilding.service.Impl.MammothUserServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	UserDetailsService customerUserService() {
		return new MammothUserServiceImpl();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated() // 所有请求页面都需要登录才能访问
				.and().formLogin().loginPage("/login").failureForwardUrl("/login?error").permitAll() // 定制登录行为,登录页面可以任意访问
				.and().logout().permitAll(); // 定制注销行为,注销请求可以任意访问
	}
}
