package edu.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class CreditCardPsCreator implements PreparedStatementCreator {
	CreditCard cc;
	String Sql="INSERT INTO CRHOLDER VALUES (?,?,?,?,?,?,?)";
	
	public CreditCardPsCreator(CreditCard cc){
		this.cc=cc;
	}

	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement(Sql);
		ps.setLong(1, cc.getId());
		ps.setString(2, cc.getName());
		ps.setDate(3, cc.getDateOFBirth());
		ps.setString(4, cc.getAddress());
		ps.setLong(5, cc.getPhoneNumber());
		ps.setLong(6, cc.getCreditLimit());
		ps.setDate(7, cc.getValidUpTo());
		return ps;
	}

}
