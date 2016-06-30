package edu.bo;

import javax.sql.DataSource;

public interface MaterialDao {
	public void setDataSource(DataSource ds);
	public boolean checkStorage(Coffee cc);
	public void addMaterial();
	public void consume(Coffee cc);
	public void printStatus();
	

}
