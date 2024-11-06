package co.edu.upb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.edu.upb")
public class UpbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpbApplication.class, args);
	}

}
