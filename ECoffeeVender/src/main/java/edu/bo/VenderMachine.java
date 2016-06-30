package edu.bo;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VenderMachine {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
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
