package com.team.login.DAO;

import com.team.login.DTO.LoginDTO;
import com.team.member.VO.MemberVO;

public interface LoginDAO{
	public MemberVO login(LoginDTO ldto) throws Exception;
}
