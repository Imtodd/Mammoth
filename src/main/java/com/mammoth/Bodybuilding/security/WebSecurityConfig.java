package com.mammoth.Bodybuilding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mammoth.Bodybuilding.service.Impl.MammothUserServiceImpl;
import com.mammoth.Bodybuilding.util.MD5Util;

/**
 * 
 * @title : WebSecurityConfig
 * @description : spring-security配置
 * @company : com.mammoth.Bodybuilding.util
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月17日 上午11:12:38
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	UserDetailsService customerUserService() {
		return new MammothUserServiceImpl();
	}

	@Bean
	public SessionRegistry getSessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

	@Autowired
	SessionRegistry sessionRegistry;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserService()).passwordEncoder(new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return MD5Util.encode((String) rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(MD5Util.encode((String) rawPassword));
			}
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").usernameParameter("loginUsername").passwordParameter("loginPassword")
        .failureUrl("/login?error=true").defaultSuccessUrl("/home").permitAll()
        .and()
        .logout().permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		/** 解决静态资源被拦截的问题 **/
		web.ignoring().antMatchers("/global/**", "/webjars/**", "/v2/api-docs", "/swagger-resources/configuration/ui",
				"/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html");
	}
}
