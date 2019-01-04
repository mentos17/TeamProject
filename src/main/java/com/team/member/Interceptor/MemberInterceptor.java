package com.team.member.Interceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team.member.Service.MemberServiceImpl;
import com.team.member.VO.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberServiceImpl memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("MemberInterceptor 호출");
		
		/*
		 * {id}/follower
		 * {id}/following
		 * {id}/gallery
		 * 에서 {id} 값 뽑아내기.
		 */
		String uri = request.getRequestURI();
		String id = "";
		Pattern pattern = Pattern.compile("(?<=" + request.getContextPath() + "\\/)\\w+");
		Matcher data = pattern.matcher(uri);
		if (data.find()) {
			id = data.group();
		}
		
		MemberVO vo = memberService.getMember(id);
		
		request.setAttribute("vo", vo);
		
		
		if(vo == null) {
			System.out.println("정보 불러오기 실패!!!");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
