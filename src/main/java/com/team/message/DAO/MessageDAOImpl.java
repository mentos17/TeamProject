package com.team.message.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.message.VO.MessageVO;
import com.team.message.VO.SendMessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO{
	
	@Autowired
	SqlSessionTemplate sqlSession;
	String namespace = "com.team.message.Mapper.messageMapper";
	
	//쪽지 전체 목록
	@Override
	public List<MessageVO>listAll()throws Exception{
		return sqlSession.selectList(namespace+".listAll");
	}
	
	//내가 보낸 쪽지
	@Override
	public List<SendMessageVO>sendListAll()throws Exception{
		return sqlSession.selectList(namespace+".listAll");
	}
	
	//쪽지 개수
	@Override
	public int countList(String message_id)throws Exception{
		return sqlSession.selectOne(namespace+".count", message_id);
	}
	
	//쪽지 작성
	@Override
	public void create(MessageVO mvo)throws Exception{
		sqlSession.insert(namespace+".insert", mvo);
	}
	
	//쪽지 상세 내용
	@Override
	public MessageVO read(MessageVO mvo)throws Exception{
		return sqlSession.selectOne(namespace+".view", mvo);
	}
	
	//내가 보낸 쪽지 상세 내용
	@Override
	public MessageVO sendRead(MessageVO mvo)throws Exception{
		return sqlSession.selectOne(namespace+".sendView", mvo);
	}
	
	//쪽지를 읽을 시, 읽지않음이 읽은 날짜로 변경된다.
	@Override
	public void updateRead(int MESSAGE_NO)throws Exception{
		sqlSession.update(namespace+".readvaltrue", MESSAGE_NO);
	}
	
	//쪽지 삭제
	@Override
	public void delete(int MESSAGE_NO)throws Exception{
		sqlSession.delete(namespace+".deleteMessage", MESSAGE_NO);
	}
}
