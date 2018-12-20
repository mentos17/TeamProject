package com.team.login;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(MemberVO mvo, @CookieValue(value="REMEMBER", required=false)Cookie rememberCookie)throws Exception{
		if (rememberCookie!=null) {
			mvo.setID(rememberCookie.getValue());
			mvo.setREMEMBERID(true);
		}
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid MemberVO mvo, BindingResult bindingResult, HttpSession session, HttpServletRequest response)throws Exception{
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		try {
			AuthInfo authInfo = loginService.loginAuth(mvo);
			session.setAttribute("authInfo", authInfo);
			Cookie rememberCookie = new Cookie("REMEMBER", mvo.getID());
			rememberCookie.setPath("/");
			if (mvo.isREMEMBERID()) {
				rememberCookie.setMaxAge(60*60*24*7);
			}else {
				rememberCookie.setMaxAge(0);
			}
		} catch (IdPasswordNotMatchingException e) {
			bindingResult.rejectValue("PWD", "notMatch", "아이디와 비밀번호가 맞지 않습니다.");
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		ModelAndView mav = new ModelAndView("loginSuccess");
		return mav;
	}	
}
