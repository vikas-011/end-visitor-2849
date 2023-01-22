package model;

public class CompletedProject {
	private int rtid;
	private int vid;
	private int pjid;
	private int rating;
	private String comment;
	
	public CompletedProject() {
		// TODO Auto-generated constructor stub
	}

	public CompletedProject(int rtid, int vid, int pjid, int rating, String comment) {
		super();
		this.rtid = rtid;
		this.vid = vid;
		this.pjid = pjid;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRtid() {
		return rtid;
	}

	public void setRtid(int rtid) {
		this.rtid = rtid;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getPjid() {
		return pjid;
	}

	public void setPjid(int pjid) {
		this.pjid = pjid;
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
		return "CompletedProject [rtid=" + rtid + ", vid=" + vid + ", pjid=" + pjid + ", rating=" + rating
				+ ", comment=" + comment + "]";
	}
	
}
