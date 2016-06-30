package edu.bo;
//debit card opening balance as 2500

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DebitCard extends Card implements CardDao {
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private long balance;
	private int pin;

	public boolean paymentValidation() {
		long cardNumber=0;
		int pwd=0;
		long Amount=0;
		
		
		Scanner sc=new Scanner(System.in);
		try {
			
			System.out.println("Enter Card Number:");
			cardNumber=sc.nextLong();
			
			System.out.println("Enter Pin:");
			pwd=sc.nextInt();
			
			System.out.println("Enter Amount:");
			Amount=sc.nextLong();
			
			
		} catch (Exception e) {
			System.out.println("Please check your format!");
			//e.printStackTrace();
		} finally{
			sc.close();
		}
		
		//-------->paying
		
		
		try {
			String sql="SELECT OPBAL, PIN FROM DRHOLDER WHERE DCNO=?";
			DebitCard dc=this.jdbcTemplate.queryForObject(sql, new Object[]{cardNumber}, 
					new RowMapper<DebitCard>(){

					public DebitCard mapRow(ResultSet rs, int num) throws SQLException {
						DebitCard dc=new DebitCard();
						dc.setBalance(rs.getLong("OPBAL"));

						dc.setPin(rs.getInt("PIN"));
						
						return dc;
					}
			});
			
			if(pwd==dc.getPin())
			{
				this.jdbcTemplate.update("UPDATE DRHOLDER SET OPBAL=OPBAL-? WHERE DCNO=?",
						Amount,cardNumber);
				System.out.println("Paid!");
				return true;
				
			}
			else{
				System.out.println("Wrong Information");
				return false;
			}
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wrong Card Number");
			return false;
		} 
	}

	public void setCardData() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Name:");
			this.setName(sc.nextLine());
			System.out.println("Date of Birth: formate(yyyy-[m]m-[d]d)");
			this.setDateOFBirth(Date.valueOf(sc.nextLine().trim()));
			System.out.println("Address:");
			this.setAddress(sc.nextLine());
			System.out.println("Phone No.:(10 digits)");
			this.setPhoneNumber(sc.nextLong());
			System.out.println("Opening Balance:");
			this.setBalance(sc.nextLong());
			System.out.println("Pin:(4 digits only)");
			this.setPin(sc.nextInt());
			
			
		} catch (Exception e) {
			System.out.println("Please check your format!");
			//e.printStackTrace();
		}
		
		this.setId();
		//--------------->store to DB
		
		
			String Sql="INSERT INTO DRHOLDER VALUES (?,?,?,?,?,?,?)";
			jdbcTemplate.update(Sql,this.getId(),this.getName(),this.getDateOFBirth(),
					this.getAddress(),this.getPhoneNumber(),this.getBalance(),this.getPin());
			
			System.out.println("Update Record Successfully!");
		
		

	}

	public void setDataSource(DataSource ds) {
		//dataSource=ds;
		jdbcTemplate=new JdbcTemplate(ds);
		
	}
	
	

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "DebitCard [balance=" + balance + ", pin=" + pin + ", Basic Info=" + super.toString() + "]";
	}
	

}
