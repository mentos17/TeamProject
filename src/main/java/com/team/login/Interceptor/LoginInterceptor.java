package com.team.login.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN  = "member";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
		super.postHandle(request, response, handler, mv);
		/*HttpSession session = request.getSession();
		ModelMap modelMap = mv.getModelMap();
		Object memberVO = modelMap.get("MemberVO");
		
		if (memberVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, memberVO);
			
			if (request.getParameter("useCookie") != null) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(3600 * 24 * 7);
				
				response.addCookie(loginCookie);
			}
			
			Object dest = session.getAttribute("dest");

			response.sendRedirect(dest != null ? (String)dest : "/mysns/board/list");
			
			response.sendRedirect("main");
			
		} else {
			session.setAttribute("isfail", "true");
			
			response.sendRedirect("login");
		}*/
	}
	
	@Override // 컨트롤러 가기 전 처리
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		// member 세션이 없을때
		if (session.getAttribute(LOGIN) == null) {
			response.sendRedirect("/TeamPro/login");
			return false;
		}
		
		return true;
	}
}
