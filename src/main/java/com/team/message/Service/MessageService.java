package com.team.message.Service;

import java.util.List;

import com.team.member.VO.MemberVO;
import com.team.message.VO.MessageVO;
import com.team.message.VO.SendMessageVO;

public interface MessageService {
	
	//쪽지 전체 목록
	public List<MessageVO>listAll()throws Exception;
	
	//내가 보낸 쪽지
	public List<SendMessageVO> sendListAll()throws Exception;
	
	//쪽지 개수
	public int countList(MemberVO memberVO)throws Exception;
		
	//쪽지 작성
	public void create(MessageVO mvo)throws Exception;
	
	//쪽지 상세 내용 
	public MessageVO read(MessageVO mvo)throws Exception;
	
	//내가 보낸 쪽지 상세 내용 
	public MessageVO sendRead(MessageVO mvo)throws Exception;
	
	//쪽지를 읽을 시, 읽지않음이 읽은 날짜로 변경된다.
	public void updateRead(int MESSAGE_NO)throws Exception;
	
	//쪽지 삭제
	public void delete(int MESSAGE_NO)throws Exception;
}
