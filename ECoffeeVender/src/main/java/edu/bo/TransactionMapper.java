package edu.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TransactionMapper implements RowMapper<Transaction> {

	public Transaction mapRow(ResultSet rs, int num) throws SQLException {
		Transaction ts=new Transaction();
		ts.setCoffessType(rs.getString("COFTYPE"));
		ts.setPayType(rs.getString("PAYTYPE"));
		ts.setDate(rs.getDate("TRDATE"));
		ts.setId(rs.getLong("TRID"));
		return ts;
	}

}
