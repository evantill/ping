package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		customizeBuilder(new SpringApplicationBuilder(DemoApplication.class)).run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return customizeBuilder(application);
	}

	private static SpringApplicationBuilder customizeBuilder(SpringApplicationBuilder application){
		return application.sources(DemoApplication.class).bannerMode(Banner.Mode.LOG);
	}

}
