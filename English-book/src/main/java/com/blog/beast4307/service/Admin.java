package com.blog.beast4307.service;

public class Admin {
	private String ADMINID;
	private String ADMINPW;
	private int LIBCODE;
	private int RESULT;
	
	

	public int getRESULT() {
		return RESULT;
	}
	public void setRESULT(int rESULT) {
		RESULT = rESULT;
	}
	public String getADMINID() {
		return ADMINID;
	}
	public void setADMINID(String aDMINID) {
		ADMINID = aDMINID;
	}
	public String getADMINPW() {
		return ADMINPW;
	}
	public void setADMINPW(String aDMINPW) {
		ADMINPW = aDMINPW;
	}
	public int getLIBCODE() {
		return LIBCODE;
	}
	public void setLIBCODE(int lIBCODE) {
		LIBCODE = lIBCODE;
	}
	@Override
	public String toString() {
		return "Admin [ADMINID=" + ADMINID + ", ADMINPW=" + ADMINPW + ", LIBCODE=" + LIBCODE + ", RESULT=" + RESULT
				+ "]";
	}
	
	
	
	
}
