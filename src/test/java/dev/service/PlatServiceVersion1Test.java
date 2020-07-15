package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

public class PlatServiceVersion1Test {

	private IPlatDao dao;
	private PlatServiceVersion1 platService;

	@BeforeEach
	void setUp() {
		dao = mock(IPlatDao.class);
		platService = new PlatServiceVersion1(dao);
	}

	@Test
	void ajouterPlatNomInvalide() {
		assertThatThrownBy(() -> platService.ajouterPlat("piz", 1400)).isInstanceOf(PlatException.class)
				.hasMessage("un plat doit avoir un nom de plus de 3 caractères");
	}

	@Test
	void ajouterPlatPrixInvalide() {
		assertThatThrownBy(() -> platService.ajouterPlat("pizzaJambon", 40)).isInstanceOf(PlatException.class)
				.hasMessage("le prix d'un plat doit être supérieur à 5 €");
	}

	@Test
	void ajouterPlatValide() {
		platService.ajouterPlat("LasagneThon", 2400);
		verify(dao).ajouterPlat("LasagneThon", 2400);
	}
}
