package com.team.chat.DAO;

import com.team.chat.VO.ChatVO;

public interface ChatDAO {
	
	public void sendMessage(ChatVO cvo) throws Exception;
}
