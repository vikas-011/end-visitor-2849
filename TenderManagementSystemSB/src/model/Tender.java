package model;

import java.sql.Date;

public class Tender {

	private int tId;
	private int pjId;
	private String prerequisite;
	private Date startDate;
	private Date endDate;
	
	public Tender() {
		// TODO Auto-generated constructor stub
	}

	public Tender(int tId, int pjId, String prerequisite, Date startDate, Date endDate) {
		super();
		this.tId = tId;
		this.pjId = pjId;
		this.prerequisite = prerequisite;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getPjId() {
		return pjId;
	}

	public void setPjId(int pjId) {
		this.pjId = pjId;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Tender [tId=" + tId + ", pjId=" + pjId + ", prerequisite=" + prerequisite + "]";
	}
	
}
