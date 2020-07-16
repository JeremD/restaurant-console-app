package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = {JdbcTestConfig.class, PlatDaoJdbc.class})
@TestPropertySource("classpath:test.properties")
public class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private PlatDaoJdbc platDaoJdbc;
	
	@Test
	void listerPlatsNonVide() {
		List<Plat> resultat = platDaoJdbc.listerPlats();
		assertThat(resultat).size();
	}
	
	@Test
	void ajouterPlatCasPassant() {
		platDaoJdbc.ajouterPlat("Lasagne Epinards", 2200);
		List<Plat> resultat = platDaoJdbc.listerPlats();
		
	}
}

