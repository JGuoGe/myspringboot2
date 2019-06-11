package com.guo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 *  @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
//@EnableAsync  //开启异步注解功能
//@EnableScheduling //开启基于注解的定时任务
@MapperScan(value = "com.guo.mapper")
@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}

//	@Bean
//	public ViewResolver myViewReolver(){
//		return new MyViewResolver();
//	}

	/**
	 * 自定义视图解析器
	 */
//	public static class MyViewResolver implements ViewResolver{
//
//		@Override
//		public View resolveViewName(String viewName, Locale locale) throws Exception {
//			return null;
//		}
//	}

}
