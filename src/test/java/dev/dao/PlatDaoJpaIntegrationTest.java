package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = {JpaConfig.class, DataSourceH2TestConfig.class, PlatDaoJpa.class})
@TestPropertySource("classpath:test.properties")
public class PlatDaoJpaIntegrationTest {

	@Autowired
	private PlatDaoJpa daoJpa;
	
	@Test
	void listerPlatsNonVide() {
		List<Plat> resultat = daoJpa.listerPlats();
		assertThat(resultat).isNotEmpty();
	}
	
	@Test
	void ajouterPlatCasPassant() {
		Plat ajoutPlat = new Plat("TarteTatin", 900);
		daoJpa.ajouterPlat(ajoutPlat.getNom(), ajoutPlat.getPrixEnCentimesEuros());
		
		List<Plat> resultat = daoJpa.listerPlats();
		assertThat(resultat).contains(ajoutPlat);
	}
}
