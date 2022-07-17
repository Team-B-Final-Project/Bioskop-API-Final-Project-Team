package com.teama.bioskop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.teama.bioskop"})
public class BioskopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioskopApplication.class, args);
	}

}
