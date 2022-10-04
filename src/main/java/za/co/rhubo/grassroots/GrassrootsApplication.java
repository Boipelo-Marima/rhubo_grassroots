package za.co.rhubo.grassroots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class GrassrootsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrassrootsApplication.class, args);
	}

}
