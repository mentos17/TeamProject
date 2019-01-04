package com.team.block.VO;

import java.sql.Date;

public class BlockVO {
	
	// Blocker -> blocking
	
	String blocker_id; // 블락 하는 아이디
	String blocking_id; // 블락 당하는 아이디
	Date block_date; // 블락 날짜
	
	
	public String getBlocker_id() {
		return blocker_id;
	}
	public void setBlocker_id(String blocker_id) {
		this.blocker_id = blocker_id;
	}
	public String getblocking_id() {
		return blocking_id;
	}
	public void setblocking_id(String blocking_id) {
		this.blocking_id = blocking_id;
	}
	public Date getBlock_date() {
		return block_date;
	}
	public void setBlock_date(Date block_date) {
		this.block_date = block_date;
	}
	
	
}
