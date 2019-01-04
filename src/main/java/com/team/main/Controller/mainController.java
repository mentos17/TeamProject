package com.team.main.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.member.VO.MemberVO;
import com.team.message.Service.MessageService;

@Controller
public class mainController {
	
	@Autowired
	MessageService messageService;

	@RequestMapping(value = "main", method = {RequestMethod.POST, RequestMethod.GET})
	public String main(HttpSession session, Model model) throws Exception{
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getID();
		
		//읽지 않은 쪽지 개수 조회
		int count = messageService.countList(memberVO);
		
		model.addAttribute("profile", memberVO);
		model.addAttribute("messageCount", count);
		model.addAttribute("pageid", id);
		model.addAttribute("isMyGall", true);
		
		return "main.jsp?center=gallery/list";
	}
	
}
