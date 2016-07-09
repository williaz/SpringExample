package atm.bean;

import java.math.BigDecimal;
import java.sql.Date;

import atm.dao.TransactionDao;

public class Customer implements TransactionDao{
	private long id;
	private String type;
	private String name;
	private String tempAddress;
	private String permAddress;
	private Date joinDate;
	private BigDecimal balance;
	private long mobile;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	//------------DAO
	
	public boolean vaildCustomer() {
		// TODO Auto-generated method stub
		return false;
	}
	public void deposit(BigDecimal money) {
		// TODO Auto-generated method stub
		
	}
	public void withdraw(BigDecimal money) {
		// TODO Auto-generated method stub
		
	}
	public void moneyTransfer(long accountNumber) {
		// TODO Auto-generated method stub
		
	}
	public void miniStatement() {
		// TODO Auto-generated method stub
		
	}

}