package com.team.msgDTO;

import java.sql.Timestamp;

public class MessageVO {
	private int message_no;
	private String message_sender;
	private String message_receiver;
	private String message_subject;
	private String message_content;
	private Timestamp message_sendtime;
	private Timestamp message_readtime;
	
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public String getMessage_sender() {
		return message_sender;
	}
	public void setMessage_sender(String message_sender) {
		this.message_sender = message_sender;
	}
	public String getMessage_receiver() {
		return message_receiver;
	}
	public void setMessage_receiver(String message_receiver) {
		this.message_receiver = message_receiver;
	}
	public String getMessage_subject() {
		return message_subject;
	}
	public void setMessage_subject(String message_subject) {
		this.message_subject = message_subject;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Timestamp getMessage_sendtime() {
		return message_sendtime;
	}
	public void setMessage_sendtime(Timestamp message_sendtime) {
		this.message_sendtime = message_sendtime;
	}
	public Timestamp getMessage_readtime() {
		return message_readtime;
	}
	public void setMessage_readtime(Timestamp message_readtime) {
		this.message_readtime = message_readtime;
	}
}
