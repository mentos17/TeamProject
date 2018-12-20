package com.team.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Resource(name="memberDao")
	private MemberDAO memberDao;
	
	
	@Override
	public AuthInfo loginAuth(MemberVO mvo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public boolean loginCheck(MemberVO mvo) throws Exception{
		user = mvo.getID();
		boolean result = memberDao.loginCheck(mvo);
		if (result) {
			MemberVO mvo2 = viewMember(mvo);
			session.setAttribute("ID", mvo2.getID());
			session.setAttribute("NAME", mvo2.getNAME());
		}
		return result;
	}*/
}
