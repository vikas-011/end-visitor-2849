package model;

public class Project {
	private int pjId;
	private String pTitle;
	private String pSummary;
	private String pDetailesDocLink;
	private String type;
	private int pAdmin;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int pjId, String pTitle, String pSummary, String pDetailesDocLink, String type, int pAdmin) {
		super();
		this.pjId = pjId;
		this.pTitle = pTitle;
		this.pSummary = pSummary;
		this.pDetailesDocLink = pDetailesDocLink;
		this.type = type;
		this.pAdmin = pAdmin;
	}

	public int getPjId() {
		return pjId;
	}

	public void setPjId(int pjId) {
		this.pjId = pjId;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpSummary() {
		return pSummary;
	}

	public void setpSummary(String pSummary) {
		this.pSummary = pSummary;
	}

	public String getpDetailesDocLink() {
		return pDetailesDocLink;
	}

	public void setpDetailesDocLink(String pDetailesDocLink) {
		this.pDetailesDocLink = pDetailesDocLink;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getpAdmin() {
		return pAdmin;
	}

	public void setpAdmin(int pAdmin) {
		this.pAdmin = pAdmin;
	}

	@Override
	public String toString() {
		return "Project [pjId=" + pjId + ", pTitle=" + pTitle + ", pSummary=" + pSummary + ", pDetailesDocLink="
				+ pDetailesDocLink + ", type=" + type + ", pAdmin=" + pAdmin + "]";
	}
	
}
