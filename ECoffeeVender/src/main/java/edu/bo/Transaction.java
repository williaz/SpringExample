package edu.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Transaction implements TransactionDao{
	private long id;
	private Date date;
	private String coffessType;
	private String payType;
	private JdbcTemplate jdbcTemplate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCoffessType() {
		return coffessType;
	}
	public void setCoffessType(String coffessType) {
		this.coffessType = coffessType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public void printStatus() {
		
		List<Transaction> lTranx=jdbcTemplate.query("SELECT * FROM TRANS", new TransactionMapper());
		Iterator<Transaction> i=lTranx.iterator();
		Transaction curTx;
		int whiteNum=0;
		int blackNum=0;
		while(i.hasNext()){
			curTx=i.next();
			if(curTx.getCoffessType().equalsIgnoreCase("Black"))
			{
				blackNum++;
			}
			else
			{
				whiteNum++;
			}
	
			
		}
		double wAmount=whiteNum*10.0;
		double bAmount=blackNum*6.0;
		double tAmount=wAmount+bAmount;
		
		System.out.print("E-Coffee Vender\nTransaction Status\n");
		System.out.println("----------------------------------------------------");
		System.out.printf("%-10s%-10s%10s%20s\n","Sr No.","Type","Quantity","Amount");
		System.out.println("----------------------------------------------------");
		System.out.printf("%-10d%-10s%10d%20.2f\n",1,"White",whiteNum,wAmount);
		System.out.printf("%-10d%-10s%10d%20.2f\n",2,"Black",blackNum,bAmount);
		System.out.println("----------------------------------------------------");
		System.out.printf("%-20s%10d%20.2f\n","Total Coffee",blackNum+whiteNum,tAmount);
	}
	
	
	public void record(String coff, String pay) {
		
		LocalDate today=LocalDate.now();
		Date day=Date.valueOf(today);
		
		Random rd=new Random();
		long id=rd.nextInt(10);
		for(int i=1;i<9;i++)
		{
			id=id*10+rd.nextInt(10);
		}
		
		jdbcTemplate.update("INSERT INTO TRANS VALUES (?,?,?,?)", id,day,coff,pay);
		
		System.out.println("Added this Transaction!");
		
	}
	public void setDataSource(DataSource ds) {
		jdbcTemplate=new JdbcTemplate(ds);
		
	}

}
