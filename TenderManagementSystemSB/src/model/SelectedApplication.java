package model;

import java.sql.Date;

public class SelectedApplication {
	private int slId;
	private int apId;
	private Date bidingDate;
	private String city;
	private String location;
	
	public SelectedApplication() {
		// TODO Auto-generated constructor stub
	}

	public SelectedApplication(int slId, int apId, Date bidingDate, String city, String location) {
		super();
		this.slId = slId;
		this.apId = apId;
		this.bidingDate = bidingDate;
		this.city = city;
		this.location = location;
	}

	public int getSlId() {
		return slId;
	}

	public void setSlId(int slId) {
		this.slId = slId;
	}

	public int getApId() {
		return apId;
	}

	public void setApId(int apId) {
		this.apId = apId;
	}

	public Date getBidingDate() {
		return bidingDate;
	}

	public void setBidingDate(Date bidingDate) {
		this.bidingDate = bidingDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "SelectedApplication [slId=" + slId + ", apId=" + apId + ", city=" + city + ", location=" + location
				+ "]";
	}
	
}
