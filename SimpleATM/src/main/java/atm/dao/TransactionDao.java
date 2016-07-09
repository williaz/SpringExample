package atm.dao;

import java.math.BigDecimal;

public interface TransactionDao {
	public boolean vaildCustomer();
	public void deposit(BigDecimal money);
	public void withdraw(BigDecimal money);
	public void moneyTransfer(long accountNumber);
	public void miniStatement();
	

}
