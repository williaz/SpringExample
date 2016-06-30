package edu.bo;

import javax.sql.DataSource;

public interface CardDao {
	public void setDataSource(DataSource ds);
	public boolean paymentValidation();
	public void setCardData();

}
