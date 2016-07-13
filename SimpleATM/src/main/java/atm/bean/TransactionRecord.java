package atm.bean;
//deprecated
import java.math.BigDecimal;
import java.sql.Date;

public class TransactionRecord {

	
	private long no;
	private String type;//deposit/withdrawal
	private BigDecimal amount;
	private BigDecimal balance;
	private Date date;
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TransactionRecord [no=" + no + ", type=" + type + ", amount=" + amount + ", balance=" + balance
				+ ", date=" + date + "]";
	}
	
	
}
