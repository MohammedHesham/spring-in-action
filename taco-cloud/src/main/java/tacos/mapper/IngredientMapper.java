package tacos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import tacos.domain.Ingredient;

public class IngredientMapper implements RowMapper<Ingredient> {

	@Override
	public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
	}

}
