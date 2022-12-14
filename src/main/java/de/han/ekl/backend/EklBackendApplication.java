package de.han.ekl.backend;

import de.han.ekl.backend.util.EklUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"de.han.ekl.backend"})
public class EklBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EklBackendApplication.class, args);
	}
}
