package com.team.login;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

public class MemberDAOImpl implements MemberDAO{
	
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberVO mvo) {
		String name = sqlSession.selectOne("login.loginCheck", mvo);
		return (name == null)?false:true;
	}
	
	/*@Override
	public MemberVO viewMember(MemberVO mvo) {
		return sqlSession.selectOne("login.viewMember", mvo);
	}
	
	@Override
	public void logout(HttpSession session) {}*/
}
