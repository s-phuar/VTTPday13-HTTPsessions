package day13.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

// our landing page, IndexController -> index.html
// user submits data, index.html -> RegistrationController
// valid data is saved and we see confirmation page, RegistrationController -> registered.html
// logout, registered.html -> SaveController -> index.html


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
