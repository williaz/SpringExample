package atm.dao;

import java.math.BigDecimal;

import atm.bean.Customer;

public interface TransactionDao {
	public Customer findCustomer(long id);
	public void deposit(Customer user,BigDecimal money);
	public void withdraw(Customer user,BigDecimal money);
	public void moneyTransfer(Customer user,long accountNumber);
	public void saveTransaction(Customer user);
	public void miniStatement(Customer user);
	

}
