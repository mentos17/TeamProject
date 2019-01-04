package com.team.login.Service;

import com.team.login.DTO.LoginDTO;
import com.team.member.VO.MemberVO;

public interface LoginService {
	public MemberVO login(LoginDTO ldto) throws Exception;
}
