package edu.bo;

import java.util.Scanner;

import javax.sql.DataSource;

public interface CardDao {
	public void setDataSource(DataSource ds);
	public long paymentValidation(Scanner sc);
	public void setCardData(Scanner sc);

}
