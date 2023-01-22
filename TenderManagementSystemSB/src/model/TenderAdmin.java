package model;

public class TenderAdmin {
	  
	  private int pid;
	  private String client;
	  private String email;
	  private String password;
	  private String country;
	  private String state;
	  private String location;
	  private String companyRegistrationNo;
	  
	  public TenderAdmin() {
		// TODO Auto-generated constructor stub
	}

	public TenderAdmin(int pid, String client, String email, String password, String country, String state,
			String location, String companyRegistrationNo) {
		super();
		this.pid = pid;
		this.client = client;
		this.email = email;
		this.password = password;
		this.country = country;
		this.state = state;
		this.location = location;
		this.companyRegistrationNo = companyRegistrationNo;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyRegistrationNo() {
		return companyRegistrationNo;
	}

	public void setCompanyRegistrationNo(String companyRegistrationNo) {
		this.companyRegistrationNo = companyRegistrationNo;
	}

	@Override
	public String toString() {
		return "TenderAdmin [pid=" + pid + ", client=" + client + ", email=" + email + ", password=" + password
				+ ", country=" + country + ", state=" + state + ", location=" + location + ", companyRegistrationNo="
				+ companyRegistrationNo + "]";
	}
	  
}
