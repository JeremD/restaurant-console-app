package dev.config;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoFichier;
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
@PropertySource("app.properties")
@ComponentScan("dev")
public class AppConfig {

	@Value("${fichierStockage}")
	private String fichier;
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public IPlatDao platDaoFichier() {
		return new PlatDaoFichier(fichier);
	}
	
	@Bean
	public IPlatService platService() {
		return new PlatServiceVersion1(platDaoFichier());
	}
	
	@Bean
	public Menu menu() {
		return new Menu(scanner(), platService());
	}
}
