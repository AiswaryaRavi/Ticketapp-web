package com.aiswarya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.aiswarya")

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
}

}
