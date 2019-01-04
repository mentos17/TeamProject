package com.team.member.VO;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class MemberVO { //DTO
	
	@Id //뜻 : 기본키
	//아이디가 최소 6자리 최대 20자리 사이에 입력되지 않은 경우의 유효성 체크
	@Size(min=6, max=20, message="아이디는 6~20자리로 입력해야 합니다.")
	private String ID;
	
	@NotNull
	@Size(min=6, max=20, message="비밀번호는 6~20자리로 입력해야 합니다.")
	private String PWD;
	
	@Size(min=2, max=13, message="이름은 최소 2자리부터 입력해야 합니다.")
	private String NAME;
	
	@Size(min=11, max=12, message="전화번호는 11~12자리로 입력해야 합니다.")
	private String PHONE;
	
	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="올바른 이메일 형식이 아닙니다.")
	private String EMAIL;
	
	@Size(min=8, max=9, message="생년월일 EX)19991120")
	private String BIRTH;
	
	private String PIC;
	private Timestamp DATE;
	private Timestamp MODDATE;
	private String FOLLOWER;
	private String FOLLOWING;
		
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
	
}
