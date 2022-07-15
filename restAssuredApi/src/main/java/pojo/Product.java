package pojo;

import java.io.Serializable;

import org.apache.juneau.annotation.Beanc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product implements Serializable {

	private String name;
	private String color;
	private int price;
	private String[] sellerNames;

	private Company company;

	@Beanc(properties="name,color,price,sellerNames,company")
	public Product(String name, String color, int price, String[] sellerNames, Company company) {

		this.name = name;
		this.color = color;
		this.price = price;
		this.sellerNames = sellerNames;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String[] getSellerNames() {
		return sellerNames;
	}

	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
