package racunari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class RacunariApp extends SpringBootServletInitializer {
	@Autowired
	private TestData td;

	public static void main(String[] args) {
		SpringApplication.run(RacunariApp.class, args);

	}

}
