package edu.bo;
//default limit in credit cards to 5000

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreditCard extends Card implements CardDao {
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private long CreditLimit=5000;
	private Date ValidUpTo;

	public long paymentValidation(Scanner sc) {
		long cardNumber=0;
		Date validDate=null;
		long Amount=0;
		//Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Enter Card Number:");
			cardNumber=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Validity Date:");
			validDate=Date.valueOf(sc.nextLine().trim());
			
			
			System.out.println("Enter Amount:");
			Amount=sc.nextLong();
			
			
		} catch (Exception e) {
			System.out.println("Please check your format!");
			//e.printStackTrace();
			
		}finally{
			//sc.close();
		}
		
		//-------->paying
		
		try {
			String sql="SELECT CRLIMIT, VALIDUPTO FROM CRHOLDER WHERE CCNO=?";
			CreditCard cc=this.jdbcTemplate.queryForObject(sql, new Object[]{cardNumber}, new CreditCardMapper());
			
			if(validDate.equals(cc.getValidUpTo()))
			{
				this.jdbcTemplate.update("UPDATE CRHOLDER SET CRLIMIT=CRLIMIT-? WHERE CCNO=?",
						Amount,cardNumber);
				System.out.println("Paid!");
				return Amount;
				
			}
			else{
				System.out.println("Wrong Information");
				return 0;
			}
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wrong Card Number");
			return 0;
		} 
	}
	

	public void setCardData(Scanner sc) {
		
		//Scanner sc=new Scanner(System.in);
		try {
			sc.nextLine();
			System.out.println("Enter Name:");
			this.setName(sc.nextLine());
			System.out.println("Date of Birth: formate(yyyy-[m]m-[d]d)");
			this.setDateOFBirth(Date.valueOf(sc.nextLine().trim()));
			System.out.println("Address:");
			this.setAddress(sc.nextLine());
			System.out.println("Phone No.:(10 digits)");
			this.setPhoneNumber(sc.nextLong());
			
			
			
		} catch (Exception e) {
			System.out.println("Please check your format!");
			//e.printStackTrace();
		} finally{
			//sc.close();
		}
		
		this.setId();
		LocalDate today=LocalDate.now().plusYears(1);
		
		this.setValidUpTo(Date.valueOf(today));
		//---------->DB
		CreditCardPsCreator psc=new CreditCardPsCreator(this); 
		jdbcTemplate.update(psc);
		
		System.out.println("Update Record Successfully!");
		
		

	}

	public void setDataSource(DataSource ds) {
		//dataSource=ds;
		jdbcTemplate=new JdbcTemplate(ds);
		
	}

	@Override
	public String toString() {
		return "CreditCard [CreditLimit=" + CreditLimit + ", ValidUpTo=" + ValidUpTo + ", Basic Info="
				+ super.toString() + "]";
	}

	public long getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(long creditLimit) {
		CreditLimit = creditLimit;
	}

	public Date getValidUpTo() {
		return ValidUpTo;
	}

	public void setValidUpTo(Date validUpTo) {
		ValidUpTo = validUpTo;
	}

	
	
	

}
