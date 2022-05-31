package one.digitalinnovation.gof;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import one.digitalinnovation.gof.ui.UserInterface;

@EnableFeignClients
@SpringBootApplication
public class Application {

	@Autowired
	private static UserInterface userInterface;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		userInterface.execute(new Scanner(System.in));
	}

}