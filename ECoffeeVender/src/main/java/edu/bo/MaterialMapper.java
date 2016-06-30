package edu.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MaterialMapper implements RowMapper<Material> {

	public Material mapRow(ResultSet rs, int num) throws SQLException {
		Material m=new Material();
		m.setCoffeePowder(rs.getInt("COFFEEPOWDER"));
		m.setSugar(rs.getInt("SUGAR"));
		m.setCreamer(rs.getInt("CREAMER"));

		return m;
	}

}
