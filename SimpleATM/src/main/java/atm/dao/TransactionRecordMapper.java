package atm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import atm.bean.TransactionRecord;

public class TransactionRecordMapper implements RowMapper<TransactionRecord> {

	public TransactionRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TransactionRecord tr=new TransactionRecord();

		tr.setNo(rs.getLong("ACC_NO"));
		tr.setDate(rs.getDate("TRAN_DATE"));
		tr.setType(rs.getString("PARTICULARS"));
		tr.setAmount(rs.getBigDecimal("AMOUNT"));
		tr.setBalance(rs.getBigDecimal("BALANCE"));
		
		return tr;
	}

}
