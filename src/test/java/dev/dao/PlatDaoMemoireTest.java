package dev.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;

class PlatDaoMemoireTest {
	
	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	void listerPlatsVideALInitialisation() {
		List<Plat> resultat = platDaoMemoire.listerPlats();
		Assertions.assertTrue(resultat.isEmpty());
	}

	@Test
	void ajouterPlatCasPassants() {
		List<Plat> resultat = platDaoMemoire.listerPlats();
		platDaoMemoire.ajouterPlat("pizzaReine", 1400);
		Assertions.assertNotNull(resultat);
	}
}