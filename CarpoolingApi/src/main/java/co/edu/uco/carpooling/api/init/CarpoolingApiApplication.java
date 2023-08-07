package co.edu.uco.carpooling.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco"})
public class CarpoolingApiApplication {

	public static void main(String[] args) {
		System.out.println(":)");
		SpringApplication.run(CarpoolingApiApplication.class, args);
	}

}
