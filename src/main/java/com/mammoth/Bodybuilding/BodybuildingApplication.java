package com.mammoth.Bodybuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @title : BodybuildingApplication
 * @description : 猛犸健身管理系统启动类
 * @company : com.mammoth.Bodybuilding
 * @project Bodybuilding
 * @author xingzhaojun
 * @date 2018年4月13日 上午10:36:45
 */
@SpringBootApplication(scanBasePackages = "com.mammoth.Bodybuilding")
@EnableRedisHttpSession
@EnableSwagger2
public class BodybuildingApplication {
	/**
	 * 启动类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BodybuildingApplication.class, args);
	}
}
