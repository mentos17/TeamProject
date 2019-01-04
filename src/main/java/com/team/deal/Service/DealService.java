package com.team.deal.Service;

import java.util.List;

import com.team.deal.DTO.DealDTO;

public interface DealService {

	// �Խù� ��� ��ȸ
	public List<DealDTO> dealList() throws Exception;

	// �Խù� �ۼ�
	public void writerDeal(DealDTO ddto) throws Exception;

	// �Խù� �� ���� ��ȸ
	public DealDTO dealRead(int DEAL_NUM)throws Exception;
	
	// �Խù� �����ϱ�
	public void updateDeal(DealDTO ddto) throws Exception;
	
	//�Խù� ����
	public void deleteDeal(int DEAL_NUM)throws Exception;

	
}


