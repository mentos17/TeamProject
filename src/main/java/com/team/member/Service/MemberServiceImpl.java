package com.team.member.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.member.DAO.MemberDAO;
import com.team.member.VO.MemberVO;


@Service
public class MemberServiceImpl{
	
	@Autowired
	MemberDAO memberDAO;
	
	public void InsertMember(MemberVO vo) {
		memberDAO.InsertMember(vo);
	}
	
	public MemberVO getMember(String ID) {
		return memberDAO.getMember(ID);
	}

	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	public List<MemberVO> GetSearchMember(Map<String, String> searchInfo) {
		// TODO Auto-generated method stub
		return memberDAO.GetSearchMember(searchInfo);
	}
}
