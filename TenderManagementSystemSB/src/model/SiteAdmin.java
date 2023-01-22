package model;

public class SiteAdmin {
	private int sid;
	private String sname;
	private String email;
	private String password;
	
	public SiteAdmin() {
		// TODO Auto-generated constructor stub
	}

	public SiteAdmin(int sid, String sname, String email, String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
		this.password = password;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	@Override
	public String toString() {
		return "SiteAdmin [sid=" + sid + ", sname=" + sname + ", email=" + email + ", password=" + password + "]";
	}
	
}
