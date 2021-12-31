package com.example.demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEncryptableProperties
@EnableWebSecurity
public class BiraProjectOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiraProjectOnboardingApplication.class, args);
	}

}
