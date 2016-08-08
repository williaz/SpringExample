package atm.bean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import atm.dao.TransactionDao;

@Component
@Entity
@Table(name="ATM_ACCOUNT")
@XmlRootElement(name="customer")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
  //An Attribute is something that is self-contained, i.e., a color, an ID, a name.
  //An Element is something that does or could have attributes of its own or contain other elements.
    @Id
   // @GeneratedValue
    @Column(name="ACC_NO")
	//private long id;
   // @XmlAttribute(required=true) 
    private Long id;
  //  @XmlElement(required=true) 
    @Column(name="ACC_TYPE")
	private String type;
  //  @XmlElement(required=true) 
    @Column(name="ACC_NAME")
	private String name;
  //  @XmlElement(required=true) 
    @Column(name="ACC_PIN")
	//private int pin;
    private Integer pin;
   // @XmlElement(required=true) 
    @Column(name="TEMP_ADDRESS")
	private String tempAddress;
   // @XmlElement(required=true) 
    @Column(name="PERM_ADDRESS")
	private String permAddress;
  //  @XmlElement(required=true) 
    @Column(name="JOIN_DATE")
	private Date joinDate;
   // @XmlElement(required=true) 
    @Column(name="BALANCE")
	private BigDecimal balance;
  //  @XmlElement(required=true) 
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
