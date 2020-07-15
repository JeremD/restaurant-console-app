package dev.config;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.IPlatService;
import dev.service.PlatServiceVersion1;

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
