package com.mammoth.Bodybuilding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 
 * @title : Swagger2
 * @description : Swagger2配置类
 * @company : com.mammoth.Bodybuilding
 * @project Bodybuilding
 * @author xingzhaojun
 * @date 2018年4月13日 上午10:38:47
 */
@Configuration
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.mammoth.Bodybuilding")).paths(PathSelectors.any())
				.build();
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("猛犸健身系统api文档").description("接口文档").termsOfServiceUrl("http://baidu.com")
				.version("1.1").build();
	}

}
