package sai.daria.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"sai.daria.helpdesk.repo"})
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
		System.out.println("Application start");
	}

}
