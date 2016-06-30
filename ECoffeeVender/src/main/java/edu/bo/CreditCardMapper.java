package edu.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CreditCardMapper implements RowMapper<CreditCard> {

	public CreditCard mapRow(ResultSet rs, int num) throws SQLException {
		CreditCard cc=new CreditCard();
		cc.setCreditLimit(rs.getLong("CRLIMIT"));

		cc.setValidUpTo(rs.getDate("VALIDUPTO"));
		
		return cc;
	}

}
