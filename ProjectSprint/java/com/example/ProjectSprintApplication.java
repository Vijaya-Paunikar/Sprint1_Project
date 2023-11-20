package com.example;
/*CloudMarketConnect*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.otp", "com.example.controller", "com.example.messaging"})
public class ProjectSprintApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(ProjectSprintApplication.class, args);
	}

}
