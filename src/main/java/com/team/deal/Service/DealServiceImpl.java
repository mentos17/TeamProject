package com.team.deal.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.deal.DAO.DealDAO;
import com.team.deal.DTO.DealDTO;

@Service
public class DealServiceImpl implements DealService{

	@Inject
	DealDAO dealDao;

	@Override
	public List<DealDTO> dealList() throws Exception {
		
		return dealDao.dealList();
	}

	@Override
	public void writerDeal(DealDTO ddto) throws Exception {
		dealDao.writerDeal(ddto);
		
	}

	@Override
	public DealDTO dealRead(int DEAL_NUM) throws Exception {
		return dealDao.dealRead(DEAL_NUM);
	}

	@Override
	public void updateDeal(DealDTO ddto) throws Exception {
		dealDao.dealUpdate(ddto);
		
	}

	@Override
	public void deleteDeal(int DEAL_NUM) throws Exception {
		dealDao.dealDelete(DEAL_NUM);
		
	}

}
