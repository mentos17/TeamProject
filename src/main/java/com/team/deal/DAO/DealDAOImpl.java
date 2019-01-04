package com.team.deal.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.deal.DTO.DealDTO;



@Repository
public class DealDAOImpl implements DealDAO {
@Inject
SqlSession sqlSession;

String namespace = "com.team.deal.Mapper.DealMapper";
	@Override
	public List<DealDTO> dealList() throws Exception {
	
		return sqlSession.selectList(namespace+".dealList");
				
	}
	@Override
	public void writerDeal(DealDTO ddto) throws Exception {
		sqlSession.insert(namespace+".dealWriter", ddto);
		
	}
	@Override
	public DealDTO dealRead(int DEAL_NUM) throws Exception {
		
		return sqlSession.selectOne(namespace+".dealRead",DEAL_NUM);
	}
	@Override
	public void dealUpdate(DealDTO ddto) throws Exception {
		sqlSession.update(namespace+".dealUpdate",ddto);
		
	}
	@Override
	public void dealDelete(int DEAL_NUM) throws Exception {
		sqlSession.delete(namespace+".dealDelete", DEAL_NUM);
		
	}

}
