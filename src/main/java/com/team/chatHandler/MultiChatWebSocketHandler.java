package com.team.chatHandler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MultiChatWebSocketHandler extends TextWebSocketHandler{
	private static Logger logger = LoggerFactory.getLogger(MultiChatWebSocketHandler.class);
	private static List<WebSocketSession>list = new ArrayList<WebSocketSession>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		list.add(session);
		logger.info("하나의 클라이언트가 연결됨", session.getId());
	}
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		logger.info(session.getId(), message.getPayload());
		for(WebSocketSession s:list) {
			s.sendMessage(new TextMessage(session.getId()+":"+message.getPayload()));
		}
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		list.remove(session);
		logger.info("클라이언트와 연결 해제됨", session.getId());
	}

}
