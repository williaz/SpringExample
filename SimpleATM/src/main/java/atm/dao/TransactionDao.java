package atm.dao;

import java.math.BigDecimal;
import java.util.List;

import atm.bean.Customer;

public interface TransactionDao {
	public Customer findCustomer(long id);
	public boolean deposit(long id,BigDecimal money);
	public boolean withdraw(long id,BigDecimal money);
	public int moneyTransfer(long givId,long revId,BigDecimal mone);
	public boolean saveTransaction(Customer user, String type,BigDecimal amount);
	public List miniStatement(Customer user);
	

}
