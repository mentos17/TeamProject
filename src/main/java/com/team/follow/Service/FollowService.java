package com.team.follow.Service;

import java.util.List;
import java.util.Map;

import com.team.follow.VO.FollowVO;

public interface FollowService {
	
	// 해당 아이디의 모든 팔로워 목록 리턴(follower_id, follow_date)
	public List<FollowVO> GetAllFollower(Map<String, String> FollowerInfo);
	
	// 해당 아이디의 모든 팔로잉 목록 리턴(following_id, follow_date)
	public List<FollowVO> GetAllFollowing(Map<String, String> FollowingInfo);
	
	// 팔로잉 삭제
	public void DeleteFollowing(FollowVO vo);
	
	// 팔로잉 추가
	public void InsertFollowing(FollowVO vo);
	
	// 팔로잉 하고 있는지 체크
	public boolean IsFollowing(FollowVO vo);

	// 팔로우 하지않은 목록 얻어오기
	public List<FollowVO> getNotFollowingList(String id);
	
	
}
