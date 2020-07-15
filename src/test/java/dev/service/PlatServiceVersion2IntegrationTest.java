package dev.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;

@SpringJUnitConfig(classes = { PlatServiceVersion2.class, PlatDaoMemoire.class, Plat.class })
@ActiveProfiles( {"memoire", "serviceV2" })
public class PlatServiceVersion2IntegrationTest {

	@Autowired
	PlatServiceVersion2 service;
	
	@Test
	void ajouterPlatValide() {
		
		Plat ajoutPlat = new Plat("LasagneThon", 2400);
		service.ajouterPlat(ajoutPlat.getNom(), ajoutPlat.getPrixEnCentimesEuros());

		List<Plat> resultat = service.listerPlats();
		assertThat(resultat).extracting(Plat::getNom).contains(ajoutPlat.getNom());
		assertThat(resultat).extracting(Plat::getPrixEnCentimesEuros).contains(ajoutPlat.getPrixEnCentimesEuros());
	}

	@Test
	void ajouterPlatprixInvalide() {
		assertThatThrownBy(() -> service.ajouterPlat("pizzaJambon", 400)).isInstanceOf(PlatException.class)
		.hasMessage("le prix d'un plat doit être supérieur à 10 €");
	}

}
