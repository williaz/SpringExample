package atm.bean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import atm.dao.TransactionDao;

@Component
@Entity
@Table(name="ATM_ACCOUNT")
public class Customer {
    @Id
   // @GeneratedValue
    @Column(name="ACC_NO")
	//private long id;
    private Long id;
    
    @Column(name="ACC_TYPE")
	private String type;
    
    @Column(name="ACC_NAME")
	private String name;
    
    @Column(name="ACC_PIN")
	//private int pin;
    private Integer pin;
    
    @Column(name="TEMP_ADDRESS")
	private String tempAddress;
    
    @Column(name="PERM_ADDRESS")
	private String permAddress;
    
    @Column(name="JOIN_DATE")
	private Date joinDate;
    
    @Column(name="BALANCE")
	private BigDecimal balance;
    
    @Column(name="MOBLIE")
	//private long mobile;
    private Long mobile;
	
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
	public Long getId() {
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	

	public Integer getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

}
