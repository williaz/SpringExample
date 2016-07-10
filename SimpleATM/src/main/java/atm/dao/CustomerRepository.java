package atm.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import atm.bean.Customer;
import atm.dao.TransactionDao;

@Repository
public class CustomerRepository implements TransactionDao {

	public boolean vaildCustomer(Customer user) {
		System.out.println(user.getId()+" "+user.getPin());
		return false;
	}

	public void deposit(Customer user, BigDecimal money) {
		// TODO Auto-generated method stub
		
	}

	public void withdraw(Customer user, BigDecimal money) {
		// TODO Auto-generated method stub
		
	}

	public void moneyTransfer(Customer user, long accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void saveTransaction(Customer user) {
		// TODO Auto-generated method stub
		
	}

	public void miniStatement(Customer user) {
		// TODO Auto-generated method stub
		
	}



}
