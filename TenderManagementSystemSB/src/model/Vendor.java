package model;

public class Vendor {
	private int vid;
	private String vname;
	private String email;
	private String country;
	private String state;
	private String address;
	private String companyRegistrationNum;
	private String gstNum;
	private String password;
	
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(int vid, String vname, String email, String country, String state, String address,
			String companyRegistrationNum, String gstNum, String password) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.email = email;
		this.country = country;
		this.state = state;
		this.address = address;
		this.companyRegistrationNum = companyRegistrationNum;
		this.gstNum = gstNum;
		this.password = password;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyRegistrationNum() {
		return companyRegistrationNum;
	}

	public void setCompanyRegistrationNum(String companyRegistrationNum) {
		this.companyRegistrationNum = companyRegistrationNum;
	}

	public String getGstNum() {
		return gstNum;
	}

	public void setGstNum(String gstNum) {
		this.gstNum = gstNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", email=" + email + ", country=" + country + ", state="
				+ state + ", address=" + address + ", companyRegistrationNum=" + companyRegistrationNum + ", gstNum="
				+ gstNum + ", password=" + password + "]";
	}
	
}
