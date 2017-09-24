package com.tcs.ilp.Teamc.bean;

public class BgcSchBean 
{
	
		public int  empidnum;
		private int bgcadmidnum;
		private String  sdate;
		private String  edate;
		private String  bgcstatus;
		public void setEmpidnum(int empidnum) {
			this.empidnum = empidnum;
		}
		public void setBgcadmidnum(int bgcadmidnum) {
			this.bgcadmidnum = bgcadmidnum;
		}
		public void setSdate(String sdate) {
			this.sdate = sdate;
		}
		public void setEdate(String edate) {
			this.edate = edate;
		}
		public void setBgcstatus(String bgcstatus) {
			this.bgcstatus = bgcstatus;
		}
		public int getEmpidnum() {
			return empidnum;
		}
		public int getBgcadmidnum() {
			return bgcadmidnum;
		}
		public String getSdate() {
			return sdate;
		}
		public String getEdate() {
			return edate;
		}
		public String getBgcstatus() {
			return bgcstatus;
		} 	 
}


