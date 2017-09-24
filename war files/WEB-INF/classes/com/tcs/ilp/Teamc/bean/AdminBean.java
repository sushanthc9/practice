package com.tcs.ilp.Teamc.bean;

public class AdminBean {
	private int adminId;
	private String adminName;
	private String adminDesig;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminDesig() {
		return adminDesig;
	}
	public void setAdminDesig(String adminDesig) {
		this.adminDesig = adminDesig;
	}
}
