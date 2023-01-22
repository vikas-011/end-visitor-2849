package model;

public class Feedback {
	private int rtId;
	private int vendorId;
	private int projectId;
	private int rating;
	private String comment;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(int rtId, int vendorId, int projectId, int rating, String comment) {
		super();
		this.rtId = rtId;
		this.vendorId = vendorId;
		this.projectId = projectId;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Feedback [rtId=" + rtId + ", vendorId=" + vendorId + ", projectId=" + projectId + ", rating=" + rating
				+ ", comment=" + comment + "]";
	}
	
}
