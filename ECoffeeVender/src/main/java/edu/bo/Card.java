package edu.bo;

import java.sql.Date;
import java.util.Random;

public abstract class Card {
	private long id;
	private String name;
	private Date dateOFBirth;
	private String address;
	private long phoneNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id){
		this.id=id;
	}
	public void setId() {
		Random rd=new Random();
		long id=rd.nextInt(10);
		for(int i=1;i<16;i++)
		{
			id=id*10+rd.nextInt(10);
		}
		this.id=id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(Date dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", dateOFBirth=" + dateOFBirth + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
