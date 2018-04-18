package com.mammoth.Bodybuilding.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserService());
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
		/** 允许所有用户访问 **/
		http.authorizeRequests().antMatchers("/mobile/**", "/register", "/forget").permitAll()
				/** 其他地址的访问均需验证权限 **/
				.anyRequest().authenticated().and()
				/** 指定登录页是"/login" **/
				.formLogin().loginPage("/login")
				/** 登录成功后默认跳转到"home" **/
				.defaultSuccessUrl("/home")
				/** 退出登录后的默认url是"/home" **/
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		/** 解决静态资源被拦截的问题 **/
		web.ignoring().antMatchers("/global/**", "/webjars/**", "/v2/api-docs", "/swagger-resources/configuration/ui",
				"/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html");
	}
}
