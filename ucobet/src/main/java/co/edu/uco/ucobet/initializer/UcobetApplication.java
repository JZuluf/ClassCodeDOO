package co.edu.uco.ucobet.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet.controller"})
public class UcobetApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcobetApplication.class, args);
	}

}
