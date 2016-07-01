package edu.bo;

import java.util.Scanner;

import javax.sql.DataSource;

public interface MaterialDao {
	public void setDataSource(DataSource ds);
	public boolean checkStorage(Coffee cc);
	public void addMaterial(Scanner sc);
	public void consume(Coffee cc);
	public void printStatus();
	

}
