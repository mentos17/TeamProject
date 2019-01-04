package com.team.chat.VO;

import java.sql.Timestamp;

public class ChatVO {
	private int CHAT_NO;
	private String CHAT_SENDER;
	private String CHAT_RECEIVER;
	private String CHAT_SENDCONTENT;
	private Timestamp CHAT_SENDTIME;
	
	//getter, setter 메서드
	public int getCHAT_NO() {
		return CHAT_NO;
	}
	public void setCHAT_NO(int cHAT_NO) {
		CHAT_NO = cHAT_NO;
	}
	public String getCHAT_SENDER() {
		return CHAT_SENDER;
	}
	public void setCHAT_SENDER(String cHAT_SENDER) {
		CHAT_SENDER = cHAT_SENDER;
	}
	public String getCHAT_RECEIVER() {
		return CHAT_RECEIVER;
	}
	public void setCHAT_RECEIVER(String cHAT_RECEIVER) {
		CHAT_RECEIVER = cHAT_RECEIVER;
	}
	public String getCHAT_SENDCONTENT() {
		return CHAT_SENDCONTENT;
	}
	public void setCHAT_SENDCONTENT(String cHAT_SENDCONTENT) {
		CHAT_SENDCONTENT = cHAT_SENDCONTENT;
	}
	public Timestamp getCHAT_SENDTIME() {
		return CHAT_SENDTIME;
	}
	public void setCHAT_SENDTIME(Timestamp cHAT_SENDTIME) {
		CHAT_SENDTIME = cHAT_SENDTIME;
	}
}
