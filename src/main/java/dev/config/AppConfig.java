package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.IPlatService;
import dev.service.PlatServiceVersion1;

/**
 * TP 02 - Spring Java
 * 
 * @author Jeremy
 *
 */

// Classe de configuration
@Configuration
@ComponentScan("dev")
public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public IPlatDao platDaoMemoire() {
		return new PlatDaoMemoire();
	}
	
	@Bean
	public IPlatService platService() {
		return new PlatServiceVersion1(platDaoMemoire());
	}
	
	@Bean
	public Menu menu() {
		return new Menu(scanner(), platService());
	}
}
