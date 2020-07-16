package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {

	// Communication avec la base de données
	private JdbcTemplate jdbcTemplate;

	public PlatDaoJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Plat> listerPlats() {
		return jdbcTemplate.query("select * from plat", new PlatRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		jdbcTemplate.update("insert into plat (nom, prix) values (?, ?)", nomPlat, prixPlat);	
	}

}
