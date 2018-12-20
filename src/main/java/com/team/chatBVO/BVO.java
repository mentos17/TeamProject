package com.team.chatBVO;

import java.sql.Timestamp;

public class BVO {
	private int mNo; //메시지 번호
	private String mSender; //발신자
	private String mReceiver; //수신자
	private String mSubject; //메시지 제목
	private String mContent; //메시지 내용
	private Timestamp mSendTime;
	private Timestamp mReadTime;
	
	//인자 생성자 생성
	public BVO(int mNo, String mSender, String mReceiver, String mSubject, String mContent, Timestamp mSendTime,
			Timestamp mReadTime) {
		this.mNo = mNo;
		this.mSender = mSender;
		this.mReceiver = mReceiver;
		this.mSubject = mSubject;
		this.mContent = mContent;
		this.mSendTime = mSendTime;
		this.mReadTime = mReadTime;
	}
	
	//getter, setter 메서드 추가
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmSender() {
		return mSender;
	}
	public void setmSender(String mSender) {
		this.mSender = mSender;
	}
	public String getmReceiver() {
		return mReceiver;
	}
	public void setmReceiver(String mReceiver) {
		this.mReceiver = mReceiver;
	}
	public String getmSubject() {
		return mSubject;
	}
	public void setmSubject(String mSubject) {
		this.mSubject = mSubject;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public Timestamp getmSendTime() {
		return mSendTime;
	}
	public void setmSendTime(Timestamp mSendTime) {
		this.mSendTime = mSendTime;
	}
	public Timestamp getmReadTime() {
		return mReadTime;
	}
	public void setmReadTime(Timestamp mReadTime) {
		this.mReadTime = mReadTime;
	}

}
