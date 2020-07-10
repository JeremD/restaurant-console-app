package dev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

/**
 * TP 01 - Spring XML
 * 
 * @author Jeremy
 *
 */
public class AppSpringXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Création du contexte Spring (dao mémoire ou fichier)
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-fichier.xml")) {
			
			// récupération du bean Menu
			Menu menu = context.getBean(Menu.class);

			// démarrage de l'application
			menu.afficher();
		}
	}

}
