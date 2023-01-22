package model;

import java.util.List;

public class Profile {
	private int pid;
	private int numOfProject;
	private List<Object> list;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Profile(int pid, int numOfProject, List<Object> list) {
		super();
		this.pid = pid;
		this.numOfProject = numOfProject;
		this.list = list;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getNumOfProject() {
		return numOfProject;
	}

	public void setNumOfProject(int numOfProject) {
		this.numOfProject = numOfProject;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Profile [pid=" + pid + ", numOfProject=" + numOfProject + ", list=" + list + "]";
	}
	
	

}
