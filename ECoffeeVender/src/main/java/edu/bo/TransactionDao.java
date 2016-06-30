package edu.bo;

import javax.sql.DataSource;

public interface TransactionDao {
	public void setDataSource(DataSource ds);
	public void record(String coff,String pay);
	public void printStatus();

}
