package com.bean;


public class Yhb {
	private Integer yhid;
	private String yhyx;
	private String yhmm;
	private String yhdh;
	private String yhnc;
	public Integer getYhid() {
		return yhid;
	}
	public void setYhid(Integer yhid) {
		this.yhid = yhid;
	}
	public String getYhyx() {
		return yhyx;
	}
	public void setYhyx(String yhyx) {
		this.yhyx = yhyx;
	}
	public String getYhmm() {
		return yhmm;
	}
	public void setYhmm(String yhmm) {
		this.yhmm = yhmm;
	}
	public String getYhdh() {
		return yhdh;
	}
	public void setYhdh(String yhdh) {
		this.yhdh = yhdh;
	}
	public String getYhnc() {
		return yhnc;
	}
	public void setYhnc(String yhnc) {
		this.yhnc = yhnc;
	}
	
	@Override
	public String toString() {
		return "Yhb [yhid=" + yhid + ", yhyx=" + yhyx + ", yhmm=" + yhmm
				+ ", yhdh=" + yhdh + ", yhnc=" + yhnc + "]";
	}

}
