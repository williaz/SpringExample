package edu.bo.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProductBean{
	
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	@XmlElement(required=true,name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(required=true,name="price")
	private double price;
	@XmlElement(required=true,name="name")
	private String name;
	

}
