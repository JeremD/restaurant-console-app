package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TP 03 - Spring Java
 * 
 * @author Jeremy
 *
 */

// Classe de configuration
@Configuration
@PropertySource("app.properties")
@ComponentScan("dev")
public class AppConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
