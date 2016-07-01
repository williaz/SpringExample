package edu.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VenderMachine {
	//Display coffee price based on user selection in Enter Amount option.
	
	//cc: 1844151792757818 2017-6-29
	//dc: 1378234631576842 1234 
	private ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	
	public long coinPaymentValidation(Scanner sc)
	{
		long one=0;
		long two=0;
		long five=0;
		
			System.out.println("E-Coffee Vender\nCash Payment\n");

			System.out.println("Insert $1 :");
			one=sc.nextLong();
			System.out.println("Insert $2 :");
			two=sc.nextLong();

			System.out.println("Insert $5 :");
			five=sc.nextLong();

		//-------->paying
			
			return one*1+two*2+five*5;
		
	}
	
	public void mainMenu(Scanner sc)
	{
		
		//Scanner sc=new Scanner(System.in);
		int choice;
		while(true){
			System.out.print("E-Coffee Vender\nMain Menu\n\n");
			System.out.println("1. Coffee Vending");
			System.out.println("2. Master Data Preparation");
			System.out.println("3. Maintenance");
			System.out.println("4. Exit");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			switch(choice){
			case 1:
				menuCoffeeType(sc);
				break;
			case 2:
				menuMasterDataPrep(sc);
				break;
			case 3:
				menuMaintenance(sc);
				break;
			case 4:
	
				break;
			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			if(choice==4)
				break;
			
		}
		
		//sc.close();
		
		
	}
	
	public void menuCoffeeType(Scanner sc){
		
		//Scanner sc=new Scanner(System.in);
		int choice;
		Material m=(Material) context.getBean("m");
		
		while(true)
		{
			System.out.print("E-Coffee Vender\nCoffee Types\n\n");
			System.out.println("1. White @ $10");
			System.out.println("2. Black @ $6");
			System.out.println("3. Back");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			
			switch(choice)
			{
			case 1:
				Coffee wc=new Coffee(5,20,10);
				if(m.checkStorage(wc))
					menuPaymentOptions(sc,wc);
				else
					System.out.println("No Enough Material");
				break;
			case 2:
				Coffee bc=new Coffee(5,0,0);
				if(m.checkStorage(bc))
					menuPaymentOptions(sc,bc);
				else
					System.out.println("No Enough Material");
				break;
			case 3:
				
				break;
			
			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			if(choice==3)
				break;
		}
		
		//sc.close();
	}
	
	public void menuPaymentOptions(Scanner sc,Coffee cf)
	{
		
		
		int choice;
		long price=0;
		Material m=(Material) context.getBean("m");
		String pay="";
		
		while(true)
		{
			System.out.print("E-Coffee Vender\nPayment Options\n\n");
			System.out.println("1. Cash");
			System.out.println("2. Credit Card");
			System.out.println("3. Debit Card");
			System.out.println("4. Back");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			switch(choice)
			{
			case 1:
				price=coinPaymentValidation(sc);
				m.consume(cf);
				pay="Cash";
				break;
			case 2:
				System.out.print("E-Coffee Vender\nCredit Card Payment\n\n");
				CreditCard cc=(CreditCard) context.getBean("cr");
				price=cc.paymentValidation(sc);
				m.consume(cf);
				pay="Credit";
				break;
			case 3:
				System.out.print("E-Coffee Vender\nDebit Card Payment\n\n");
				DebitCard dc=(DebitCard) context.getBean("dr");
				price=dc.paymentValidation(sc);
				m.consume(cf);
				pay="Debit";
				break;
			case 4:
				
				break;
			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			
			if(choice==4)
				break;
			
			//receipt------------------
			String type;
			
			if(cf.getCreamer()!=0)
				type="White";
			else
				type="Black";
			
			
			
			// transaction
						Transaction t=(Transaction)context.getBean("tr");
						t.record(type, pay);
			
			LocalDate today=LocalDate.now();
			System.out.println("E-Coffee Receipt");
			System.out.printf("%-20s : %s\n","Date",today);
			System.out.println("Coffee Type : "+type);
			System.out.println("Price : "+price);
			System.out.printf("%-20s\n","Thanks-Visit Again");
			
		}
		
		
		
		
		
		
	}
	
	public void menuMasterDataPrep(Scanner sc)
	{
		
		//Scanner sc=new Scanner(System.in);
		int choice;
		while(true)
		{
			System.out.print("E-Coffee Vender\nMaster Data Preparation\n\n");
			System.out.println("1. Credit Card Holders");
			System.out.println("2. Debit Card Holders");
			System.out.println("3. Back");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			switch(choice)
			{
			case 1:
				System.out.print("E-Coffee Vender\nCredit Card Holders Data Entry\n\n");
				CreditCard cc=(CreditCard) context.getBean("cr");
				cc.setCardData(sc);
				
				break;
			case 2:
				System.out.print("E-Coffee Vender\nDebit Card Holders Data Entry\n\n");
				DebitCard dc=(DebitCard) context.getBean("dr");
				dc.setCardData(sc);
				break;
			case 3:
				
				break;
			
			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			if(choice==3)
				break;
		}
		
	}

	public void menuMaintenance(Scanner sc)
	{
		
		
		int choice;
		
		while(true)
		{
			System.out.print("E-Coffee Vender\nMaintenance\n\n");
			System.out.println("1. Add Material");
			System.out.println("2. Change Paasword");
			System.out.println("3. Reports");
			System.out.println("4. Back");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			switch(choice)
			{
			case 1:
				Material m=(Material) context.getBean("m");
				m.addMaterial(sc);
				break;
			case 2:
				Password p=(Password) context.getBean("pwd");
				p.changePassword(sc);
				break;
			case 3:
				menuReports(sc);
				break;
			case 4:
				
				break;
			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			
			if(choice==4)
				break;
		}
		
		
	}
	
	public void menuReports(Scanner sc)
	{

		
		int choice;
		
		while(true)
		{
			System.out.print("E-Coffee Vender\nReports\n\n");
			System.out.println("1. Material Status");
			System.out.println("2. Transaction Report");
			System.out.println("3. Back");
			
			System.out.println("\nEnter Your Choice:");
			//if(sc.hasNextInt()){
				choice=sc.nextInt();
			//}
			//else
			//	choice=0;
			
			switch(choice)
			{
			case 1:
				Material m=(Material) context.getBean("m");
				m.printStatus();
				break;
			case 2:
				Transaction t=(Transaction)context.getBean("tr");
				t.printStatus();
				break;
			case 3:
				
				break;

			default:
				System.out.println("Invaild Choice! Try Again!");
				break;
			
			}
			
			
			if(choice==3)
				break;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		VenderMachine vm=new VenderMachine();
		Scanner sc=new Scanner(System.in);
		vm.mainMenu(sc);
		sc.close();
		
		
		
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//CreditCard cc=(CreditCard) context.getBean("cr");
		//cc.paymentValidation();//1844151792757818 2017-6-29
		//DebitCard dc=(DebitCard) context.getBean("dr");
		//dc.paymentValidation();//1378234631576842 1234 
		//Material m=(Material) context.getBean("m");
		//m.printStatus();
		//In case of White Coffee, 5 gr of coffee powder, 20gr. of sugar 
		//and 10 gr. of creamer is required and 
		//in case of black coffee only 5 gr. of coffee powder is required.
		/*Coffee wc=new Coffee(5,20,10);
		Coffee bc=new Coffee(5,0,0);
		System.out.println(m.checkStorage(wc));
		m.consume(bc);
		m.consume(wc);
		m.addMaterial();
		m.printStatus();
		
		Transaction t=(Transaction)context.getBean("tr");
		
		t.record("Black", "Cash");*/
		
		/*Coffee bc=new Coffee(5,0,0);
		System.out.println(m.checkStorage(bc));
		m.consume(bc);
		Transaction t=(Transaction)context.getBean("tr");
		
		t.record("Black", "Cash");
		m.printStatus();*/
		
		/*Transaction t=(Transaction)context.getBean("tr");
		t.printStatus();*/
		
		/*Password p=(Password) context.getBean("pwd");
		p.changePassword();*/
		
		
		

	}

}
