package com.team.login;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MemberVO { //DTO
	@NotEmpty(message="아이디를 입력해주세요.")
	private String ID;
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String PWD;
	private String NAME;
	private String PHONE;
	private String EMAIL;
	private String PIC;
	private Timestamp DATE;
	private Timestamp MODDATE;
	private String FOLLOWER;
	private String FOLLOWING;
	private String BIRTH;
	private boolean REMEMBERID;
	
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
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPIC() {
		return PIC;
	}
	public void setPIC(String pIC) {
		PIC = pIC;
	}
	public Timestamp getDATE() {
		return DATE;
	}
	public void setDATE(Timestamp dATE) {
		DATE = dATE;
	}
	public Timestamp getMODDATE() {
		return MODDATE;
	}
	public void setMODDATE(Timestamp mODDATE) {
		MODDATE = mODDATE;
	}
	public String getFOLLOWER() {
		return FOLLOWER;
	}
	public void setFOLLOWER(String fOLLOWER) {
		FOLLOWER = fOLLOWER;
	}
	public String getFOLLOWING() {
		return FOLLOWING;
	}
	public void setFOLLOWING(String fOLLOWING) {
		FOLLOWING = fOLLOWING;
	}
	public String getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(String bIRTH) {
		BIRTH = bIRTH;
	}
	public boolean isREMEMBERID() {
		return REMEMBERID;
	}
	public void setREMEMBERID(boolean rEMEMBERID) {
		REMEMBERID = rEMEMBERID;
	}	
}
