package mate.academy.javabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class JavaBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBotApplication.class, args);
		System.out.println("Hello world!");
		System.out.println("11");
	}

}