package com.team.message.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.member.VO.MemberVO;
import com.team.message.Service.MessageService;
import com.team.message.VO.MessageVO;
import com.team.message.VO.SendMessageVO;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
		
	//쪽지 전체 목록
	@RequestMapping(value="{id}/messageList", method=RequestMethod.GET)
	public String messageList(@PathVariable String id, HttpSession session, Model model)throws Exception{
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		model.addAttribute("profile", memberVO);
		
		int count = messageService.countList(memberVO);
		model.addAttribute("messageCount", count);
		
		List<MessageVO>mlist = messageService.listAll();		
		model.addAttribute("mlist", mlist);
		
		return "main.jsp?center=message/messageList";
	}
	
	//내가 보낸 쪽지
	@RequestMapping(value="{id}/messageSendList", method=RequestMethod.GET)
	public String messageSendList(@PathVariable String id, HttpSession session, Model model)throws Exception{
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		model.addAttribute("profile", memberVO);
		
		int count = messageService.countList(memberVO);
		model.addAttribute("messageCount", count);
		
		List<SendMessageVO>mslist = messageService.sendListAll();
		model.addAttribute("mslist", mslist);
		
		return "main.jsp?center=message/messageSendList";
	}
	
	//쪽지 작성
	@RequestMapping(value="{id}/messageSend", method=RequestMethod.GET)
	public String messageSend(MessageVO mvo, Model model) {		
		return "message/messageSend";
	}
	
	//쪽지 보내기
	@RequestMapping(value="{id}/messageSend", method=RequestMethod.POST)
	public String messageSendOk(MessageVO mvo, Model model)throws Exception{
		
		messageService.create(mvo);
		
		return "message/messageSendOk";
	}
	
	//쪽지 답장
	@RequestMapping(value="{id}/messageResend", method=RequestMethod.GET)
	public String messageResend(@ModelAttribute("MessageVO")MessageVO mvo, Model model, HttpSession session, HttpServletRequest request)throws Exception{
		int MESSAGE_NO = Integer.parseInt(request.getParameter("MESSAGE_NO"));
		mvo.setMESSAGE_NO(MESSAGE_NO);
		MessageVO resultVO = messageService.read(mvo);
		messageService.updateRead(MESSAGE_NO);
		model.addAttribute("mdto", resultVO);
		return "message/messageResend";
	}
	
	//쪽지 답장 보내기
		@RequestMapping(value="{id}/messageResend", method=RequestMethod.POST)
		public String messageResendOk(MessageVO mvo, Model model)throws Exception{
			
			messageService.create(mvo);
			
			return "message/messageSendOk";
		}
	
	//쪽지 상세내용 조회
	//쪽지 조회시 읽음으로 변경되고, 읽은 날짜가 변경된다.(이후 변경되지는 않음)
	@RequestMapping(value="{id}/messageView", method=RequestMethod.GET)
	public String messageView(@ModelAttribute("MessageVO")MessageVO mvo, Model model, HttpServletRequest request)throws Exception{
		int MESSAGE_NO = Integer.parseInt(request.getParameter("MESSAGE_NO"));
		mvo.setMESSAGE_NO(MESSAGE_NO);
		MessageVO resultVO = messageService.read(mvo);
		messageService.updateRead(MESSAGE_NO);
		model.addAttribute("mdto", resultVO);
		return "message/messageView";
	}

	//내가 보낸 쪽지 상세내용 조회
	@RequestMapping(value="{id}/messageSendView", method=RequestMethod.GET)
	public String messageSendView(@ModelAttribute("MessageVO")MessageVO mvo, Model model, HttpServletRequest request)throws Exception{
		int MESSAGE_NO = Integer.parseInt(request.getParameter("MESSAGE_NO"));
		mvo.setMESSAGE_NO(MESSAGE_NO);
		MessageVO resultVO = messageService.sendRead(mvo);
		model.addAttribute("msdto", resultVO);
		return "message/messageSendView";
	}

	//쪽지 삭제
	@RequestMapping(value="{id}/messageDelete")
	public String messageDelete(@RequestParam int MESSAGE_NO)throws Exception{
		messageService.delete(MESSAGE_NO);
		return "redirect:messageList";
	}
	
}
