package com.team.chat.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.chat.Service.ChatService;
import com.team.chat.VO.ChatVO;
import com.team.member.VO.MemberVO;

@Controller
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	//채팅 접속
	@RequestMapping(value="{id}/multiChat", method=RequestMethod.GET)
	public String multiChat(@PathVariable String id, HttpSession session, Model model)throws Exception{
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		model.addAttribute("profile", memberVO);
		
		return "chat/multiChat";
	}
	
	//내가 보낸 메세지
	@RequestMapping(value="{id}/multiChat", method=RequestMethod.POST)
	public void chatSend(ChatVO cvo, Model model)throws Exception{
		chatService.chatSend(cvo);
	}

}
