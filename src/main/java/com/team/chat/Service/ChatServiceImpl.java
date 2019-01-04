package com.team.chat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.chat.DAO.ChatDAO;
import com.team.chat.VO.ChatVO;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	ChatDAO chatDao;
	
	@Override
	public void chatSend(ChatVO cvo) throws Exception{
		
		String CHAT_SENDER = cvo.getCHAT_SENDER();
		String CHAT_RECEIVER = cvo.getCHAT_RECEIVER();
		String CHAT_SENDCONTENT = cvo.getCHAT_SENDCONTENT();
	
		//태그문자 처리
		CHAT_SENDER = CHAT_SENDER.replace("<", "&lt;");
		CHAT_SENDER = CHAT_SENDER.replace(">", "&gt;");
		CHAT_RECEIVER = CHAT_RECEIVER.replace("<", "&lt;");
		CHAT_RECEIVER = CHAT_RECEIVER.replace(">", "&gt;");
		
		//공백문자 처리
		CHAT_SENDER = CHAT_SENDER.replace(" ", "&nbsp;&nbsp;");
		CHAT_RECEIVER = CHAT_RECEIVER.replace(" ", "&nbsp;&nbsp;");
		
		//줄바꿈 문자 처리
		CHAT_SENDCONTENT = CHAT_SENDCONTENT.replace("\n", "<br>");
		
		cvo.setCHAT_SENDCONTENT(CHAT_SENDCONTENT);
		cvo.setCHAT_RECEIVER(CHAT_RECEIVER);
		cvo.setCHAT_SENDER(CHAT_SENDER);
		
		chatDao.sendMessage(cvo);
	}
}
