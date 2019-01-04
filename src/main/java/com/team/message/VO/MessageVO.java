package com.team.message.VO;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class MessageVO {
	
	private int MESSAGE_NO; //쪽지 번호(뷰페이지에서 나타나지는 않는다.)
	private String MESSAGE_SENDER; //쪽지 송신자
	private String MESSAGE_RECEIVER; //쪽지 수신자
	private String MESSAGE_SUBJECT; //쪽지 제목
	private String MESSAGE_CONTENT; //쪽지 내용
	private Timestamp MESSAGE_SENDTIME; //쪽지 보낸 시간(송신자)
	private Timestamp MESSAGE_READTIME;
	private boolean MESSAGE_READVAL; //쪽지 확인 여부
	
	//getter, setter 메서드
	public int getMESSAGE_NO() {
		return MESSAGE_NO;
	}
	public void setMESSAGE_NO(int mESSAGE_NO) {
		MESSAGE_NO = mESSAGE_NO;
	}
	public String getMESSAGE_SENDER() {
		return MESSAGE_SENDER;
	}
	public void setMESSAGE_SENDER(String mESSAGE_SENDER) {
		MESSAGE_SENDER = mESSAGE_SENDER;
	}
	public String getMESSAGE_RECEIVER() {
		return MESSAGE_RECEIVER;
	}
	public void setMESSAGE_RECEIVER(String mESSAGE_RECEIVER) {
		MESSAGE_RECEIVER = mESSAGE_RECEIVER;
	}
	public String getMESSAGE_SUBJECT() {
		return MESSAGE_SUBJECT;
	}
	public void setMESSAGE_SUBJECT(String mESSAGE_SUBJECT) {
		MESSAGE_SUBJECT = mESSAGE_SUBJECT;
	}
	public String getMESSAGE_CONTENT() {
		return MESSAGE_CONTENT;
	}
	public void setMESSAGE_CONTENT(String mESSAGE_CONTENT) {
		MESSAGE_CONTENT = mESSAGE_CONTENT;
	}
	public Timestamp getMESSAGE_SENDTIME() {
		return MESSAGE_SENDTIME;
	}
	public void setMESSAGE_SENDTIME(Timestamp mESSAGE_SENDTIME) {
		MESSAGE_SENDTIME = mESSAGE_SENDTIME;
	}
	public Timestamp getMESSAGE_READTIME() {
		return MESSAGE_READTIME;
	}
	public void setMESSAGE_READTIME(Timestamp mESSAGE_READTIME) {
		MESSAGE_READTIME = mESSAGE_READTIME;
	}
	public boolean getMESSAGE_READVAL() {
		return MESSAGE_READVAL;
	}
	public void setMESSAGE_READVAL(boolean mESSAGE_READVAL) {
		MESSAGE_READVAL = mESSAGE_READVAL;
	}
	
}
