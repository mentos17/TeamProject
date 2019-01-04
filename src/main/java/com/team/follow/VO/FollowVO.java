package com.team.follow.VO;

import java.sql.Date;

public class FollowVO {
	
	// follower -> following
	
	String follower_id; // 팔로우 하는 아이디
	String following_id; // 팔로우 당하는 아이디
	Date follow_date; // 팔로우 날짜
	
	
	public String getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}
	public String getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(String following_id) {
		this.following_id = following_id;
	}
	public Date getFollow_date() {
		return follow_date;
	}
	public void setFollow_date(Date follow_date) {
		this.follow_date = follow_date;
	}
	
	
}
