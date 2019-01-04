package com.team.chat.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.chat.VO.ChatVO;

@Repository
public class ChatDAOImpl implements ChatDAO{
	
	@Autowired
	SqlSessionTemplate sqlSession;
	String namespace = "com.team.chat.Mapper.chatMapper";
	
	public void sendMessage(ChatVO cvo) throws Exception{
		sqlSession.insert(namespace+".insert", cvo);
	}
}
