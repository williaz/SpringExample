package edu.bo;

import java.sql.Date;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

//Appropriate quantity from [material.dat] should be deducted. 
//In case of White Coffee, 5 gr of coffee powder, 20gr. of sugar 
//and 10 gr. of creamer is required and in case of black coffee 
//only 5 gr. of coffee powder is required.

public class Material implements MaterialDao{
	private int coffeePowder;
	private int sugar;
	private int creamer;
	private JdbcTemplate jdbcTemplate;
	private final String sqlSelect="SELECT * FROM MATERIAL";
	
	
	
	public int getCoffeePowder() {
		return coffeePowder;
	}
	public void setCoffeePowder(int coffeePowder) {
		this.coffeePowder = coffeePowder;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public int getCreamer() {
		return creamer;
	}
	public void setCreamer(int creamer) {
		this.creamer = creamer;
	}
	public boolean checkStorage(Coffee cc) {
		Material m=jdbcTemplate.queryForObject(sqlSelect, new MaterialMapper());
		if(cc.getCreamer()<=m.getCreamer()&&cc.getCoffeePowder()<=m.getCoffeePowder()
				&&cc.getSugar()<=m.getSugar())
		{
			
			return true;
		}
		else
		  return false;
	}
	public void addMaterial(Scanner sc) {
		int cp=0;
		int cm=0;
		int sg=0;
		//Scanner sc=new Scanner(System.in);
		
		try {
			System.out.print("E-Coffee Vender\nAdd Material\n");
			System.out.println("Enter Quantity to Add");
			System.out.println("Coffee Powder:");
			cp=sc.nextInt();
			
			System.out.println("Creamer :");
			cm=sc.nextInt();
			
			System.out.println("Sugar :");
			sg=sc.nextInt();
			
			
		} catch (Exception e) {
			System.out.println("Please check your format!");
			//e.printStackTrace();
			
		}finally{
			//sc.close();
		}
		
		jdbcTemplate.update("UPDATE MATERIAL SET COFFEEPOWDER=COFFEEPOWDER+?,SUGAR=SUGAR+?,"
				+ "CREAMER=CREAMER+?",cp,cm,sg);
		System.out.println("Added");
		
	}
	
	public void consume(Coffee cc) {
		jdbcTemplate.update("UPDATE MATERIAL SET COFFEEPOWDER=COFFEEPOWDER-?,SUGAR=SUGAR-?,"
				+ "CREAMER=CREAMER-?",cc.getCoffeePowder(),cc.getSugar(),cc.getCreamer());
		
	}
	
	public void printStatus() {
		Material m=jdbcTemplate.queryForObject(sqlSelect, new MaterialMapper());
		System.out.print("E-Coffee Vender\nMaterial Status\n");
		System.out.println("Available Coffee Powder : "+m.getCoffeePowder()+" gms.");
		System.out.println("Available Creamer : "+m.getCreamer()+" gms.");
		System.out.println("Available Sugar: "+m.getSugar()+" gms.");
	}
	public void setDataSource(DataSource ds) {
		jdbcTemplate=new JdbcTemplate(ds);
		
	}
	
	
	
	

}
