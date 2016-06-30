package edu.bo;

import java.util.Scanner;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Password extends JdbcDaoSupport implements PasswordDao{
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void changePassword() {
		String oldP;
		String newP;
		String confP;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("E-Coffee Vender\nChange Password\n");
		System.out.println("Current Password :");
		oldP=sc.nextLine();
		
		String pwd=this.getJdbcTemplate().queryForObject("SELECT PASSWORD FROM PASSTEXT", String.class);
		
		if(pwd.equals(oldP)){
			System.out.println("New Password :");
			newP=sc.nextLine();
			System.out.println("Confirm Password :");
			confP=sc.nextLine();
			if(newP.equals(confP))
			{
				this.getJdbcTemplate().update("UPDATE PASSTEXT SET PASSWORD=?",newP);
				System.out.println("Updated Password!");
			}
			else
				System.out.println("New Passwords Dismatch!");
		}
		else
		{
			System.out.println("Wrong Password!");
		}
		
		
		
		
	}
	

}
