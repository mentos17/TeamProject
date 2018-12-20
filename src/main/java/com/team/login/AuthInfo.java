package com.team.login;

public class AuthInfo {
	private String ID;
	private String PWD;
	private String NAME;
	public AuthInfo(String ID, String PWD, String NAME) {
		this.ID = ID;
		this.PWD = PWD;
		this.NAME = NAME;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}	
}
