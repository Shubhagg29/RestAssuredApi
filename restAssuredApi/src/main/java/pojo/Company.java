package pojo;

import java.io.Serializable;

import org.apache.juneau.annotation.Beanc;



public class Company implements Serializable{
	
	private String cname;
	private String location;
	private String worth;

	
	@Beanc(properties="cname,location,worth")
	public Company(String cname, String location, String worth) {

		this.cname = cname;
		this.location = location;
		this.worth = worth;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorth() {
		return worth;
	}

	public void setWorth(String worth) {
		this.worth = worth;
	}

}
