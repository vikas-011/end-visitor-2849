package model;

public class Application {
	private int  appId;
	private int vid;
	private int tId;
	private String detailsDoc;
	private String aStatus;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(int appId, int vid, int tId, String detailsDoc, String aStatus) {
		super();
		this.appId = appId;
		this.vid = vid;
		this.tId = tId;
		this.detailsDoc = detailsDoc;
		this.aStatus = aStatus;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getDetailsDoc() {
		return detailsDoc;
	}

	public void setDetailsDoc(String detailsDoc) {
		this.detailsDoc = detailsDoc;
	}

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", vid=" + vid + ", tId=" + tId + ", detailsDoc=" + detailsDoc
				+ ", aStatus=" + aStatus + "]";
	}
	
}
