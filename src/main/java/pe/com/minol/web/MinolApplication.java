package pe.com.minol.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "pe.com.minol.core.conf","pe.com.minol.web.controller" })
public class MinolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinolApplication.class, args);
	}

}
