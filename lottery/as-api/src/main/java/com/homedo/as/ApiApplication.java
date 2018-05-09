package com.homedo.as;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ImportResource("classpath:transaction.xml")
@EnableScheduling
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApiApplication.class);
		app.setBannerMode(Banner.Mode.OFF); //可以关闭程序启动时日志中的spring图形
		app.run(args);
	}
}
