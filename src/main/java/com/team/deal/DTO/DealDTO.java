package com.team.deal.DTO;

import java.sql.Timestamp;

public class DealDTO {

	private int DEAL_NUM;
	private String DEAL_ID;
	private String DEAL_SUBJECT;
	private String DEAL_CONTENT;
	private String DEAL_REGION;
	private String DEAL_IMG;
	private int DEAL_RE_REF;
	private int DEAL_RE_LEV;
	private int DEAL_RE_SEQ;
	private int DEAL_READCOUNT;
	private Timestamp DEAL_DATETIME;
	
	//Constructor
	public DealDTO() {};
	public DealDTO(int dEAL_NUM, String dEAL_ID, String dEAL_SUBJECT, String dEAL_CONTENT, String dEAL_REGION,
			String dEAL_IMG, int dEAL_RE_REF, int dEAL_RE_LEV, int dEAL_RE_SEQ, int dEAL_READCOUNT,
			Timestamp dEAL_DATETIME) {
		super();
		DEAL_NUM = dEAL_NUM;
		DEAL_ID = dEAL_ID;
		DEAL_SUBJECT = dEAL_SUBJECT;
		DEAL_CONTENT = dEAL_CONTENT;
		DEAL_REGION = dEAL_REGION;
		DEAL_IMG = dEAL_IMG;
		DEAL_RE_REF = dEAL_RE_REF;
		DEAL_RE_LEV = dEAL_RE_LEV;
		DEAL_RE_SEQ = dEAL_RE_SEQ;
		DEAL_READCOUNT = dEAL_READCOUNT;
		DEAL_DATETIME = dEAL_DATETIME;
	}
	
	
	//getter&setter
	public int getDEAL_NUM() {
		return DEAL_NUM;
	}

	public void setDEAL_NUM(int dEAL_NUM) {
		DEAL_NUM = dEAL_NUM;
	}
	public String getDEAL_ID() {
		return DEAL_ID;
	}
	public void setDEAL_ID(String dEAL_ID) {
		DEAL_ID = dEAL_ID;
	}
	public String getDEAL_SUBJECT() {
		return DEAL_SUBJECT;
	}
	public void setDEAL_SUBJECT(String dEAL_SUBJECT) {
		DEAL_SUBJECT = dEAL_SUBJECT;
	}
	public String getDEAL_CONTENT() {
		return DEAL_CONTENT;
	}
	public void setDEAL_CONTENT(String dEAL_CONTENT) {
		DEAL_CONTENT = dEAL_CONTENT;
	}
	public String getDEAL_REGION() {
		return DEAL_REGION;
	}
	public void setDEAL_REGION(String dEAL_REGION) {
		DEAL_REGION = dEAL_REGION;
	}
	public String getDEAL_IMG() {
		return DEAL_IMG;
	}
	public void setDEAL_IMG(String dEAL_IMG) {
		DEAL_IMG = dEAL_IMG;
	}
	public int getDEAL_RE_REF() {
		return DEAL_RE_REF;
	}
	public void setDEAL_RE_REF(int dEAL_RE_REF) {
		DEAL_RE_REF = dEAL_RE_REF;
	}
	public int getDEAL_RE_LEV() {
		return DEAL_RE_LEV;
	}
	public void setDEAL_RE_LEV(int dEAL_RE_LEV) {
		DEAL_RE_LEV = dEAL_RE_LEV;
	}
	public int getDEAL_RE_SEQ() {
		return DEAL_RE_SEQ;
	}
	public void setDEAL_RE_SEQ(int dEAL_RE_SEQ) {
		DEAL_RE_SEQ = dEAL_RE_SEQ;
	}
	public int getDEAL_READCOUNT() {
		return DEAL_READCOUNT;
	}
	public void setDEAL_READCOUNT(int dEAL_READCOUNT) {
		DEAL_READCOUNT = dEAL_READCOUNT;
	}
	public Timestamp getDEAL_DATETIME() {
		return DEAL_DATETIME;
	}
	public void setDEAL_DATETIME(Timestamp dEAL_DATETIME) {
		DEAL_DATETIME = dEAL_DATETIME;
	}


	@Override
	public String toString() {
		return "DealDTO [DEAL_NUM=" + DEAL_NUM + ", DEAL_ID=" + DEAL_ID + ", DEAL_SUBJECT=" + DEAL_SUBJECT
				+ ", DEAL_CONTENT=" + DEAL_CONTENT + ", DEAL_REGION=" + DEAL_REGION + ", DEAL_IMG=" + DEAL_IMG
				+ ", DEAL_RE_REF=" + DEAL_RE_REF + ", DEAL_RE_LEV=" + DEAL_RE_LEV + ", DEAL_RE_SEQ=" + DEAL_RE_SEQ
				+ ", DEAL_READCOUNT=" + DEAL_READCOUNT + ", DEAL_DATETIME=" + DEAL_DATETIME + "]";
	}
	
	//toString
	
	
	
}
