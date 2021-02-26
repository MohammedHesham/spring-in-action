package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.domain.Ingredient;
import tacos.mapper.IngredientMapper;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate.query("select id,name, type from Ingredient", new IngredientMapper());

	}

	@Override
	public Ingredient findOne(String id) {
		String query = "select * from Ingredient where id=\'" + id+"\'";
		return jdbcTemplate.queryForObject(query, new IngredientMapper());
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		String query = "insert into Ingredient (id,name,type) values (?,?,?)";
		jdbcTemplate.update(query, ingredient.getId(), ingredient.getName(), ingredient.getType().name());
		return ingredient;
	}

}
