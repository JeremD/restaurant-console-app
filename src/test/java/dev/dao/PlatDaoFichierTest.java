package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

@SpringJUnitConfig(classes = { PlatDaoFichier.class })
@ActiveProfiles( {"fichier", "serviceV1" })
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlatDaoFichierTest {

	@Autowired
	PlatDaoFichier dao;
	
	@Test
	void ajouterPremierPlat() {
		
		Plat ajoutPlat = new Plat("LasagneThon", 2400);
		dao.ajouterPlat(ajoutPlat.getNom(), ajoutPlat.getPrixEnCentimesEuros());
		
		List<Plat> resultat = dao.listerPlats();
		assertThat(resultat).extracting(Plat::getNom).contains(ajoutPlat.getNom());
		assertThat(resultat).extracting(Plat::getPrixEnCentimesEuros).contains(ajoutPlat.getPrixEnCentimesEuros());
	}
	
	@Test
	void ajouterSecondPlat() {
		
		Plat ajoutPlat = new Plat("TarteChocolat", 1900);
		dao.ajouterPlat(ajoutPlat.getNom(), ajoutPlat.getPrixEnCentimesEuros());
		
		List<Plat> resultat = dao.listerPlats();
		assertThat(resultat).extracting(Plat::getNom).contains(ajoutPlat.getNom());
		assertThat(resultat).extracting(Plat::getPrixEnCentimesEuros).contains(ajoutPlat.getPrixEnCentimesEuros());
	}
}