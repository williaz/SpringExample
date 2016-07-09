package atm.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionRecord {

	private long tranctionId;
	private long id;
	private String particulars;//deposit/withdrawal
	private BigDecimal amount;
	private BigDecimal balance;
	private Date tranDate;
	public long getTranctionId() {
		return tranctionId;
	}
	public void setTranctionId(long tranctionId) {
		this.tranctionId = tranctionId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	
}
