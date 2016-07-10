package atm.bean;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

import atm.dao.TransactionDao;

@Component
public class Customer {
	private long id;
	private String type;
	private String name;
	private int pin;
	private String tempAddress;
	private String permAddress;
	private Date joinDate;
	private BigDecimal balance;
	private long mobile;
	
	public Customer() {super();};
	
	public Customer(long id, String type, String name, int pin, String tempAddress, String permAddress, Date joinDate,
			BigDecimal balance, long mobile) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.pin = pin;
		this.tempAddress = tempAddress;
		this.permAddress = permAddress;
		this.joinDate = joinDate;
		this.balance = balance;
		this.mobile = mobile;
	}
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
	

	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

}
