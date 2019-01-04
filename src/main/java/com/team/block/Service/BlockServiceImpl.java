package com.team.block.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.block.DAO.BlockDAO;
import com.team.block.VO.BlockVO;

@Service("BlockService")
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockDAO blockDAO;
	
	@Override
	public List<BlockVO> GetAllBlocker(String id) {
		// 해당 아이디의 모든 blocker 목록 리턴(Blocker_id, Block_date)
		return blockDAO.GetAllBlocker(id);
	}

	@Override
	public List<BlockVO> GetAllBlocking(String id) {
		// 해당 아이디의 모든 blocking 목록 리턴(Blocking_id, Block_date)
		return blockDAO.GetAllBlocking(id);
	}

	@Override
	public void DeleteBlocking(BlockVO vo) {
		blockDAO.DeleteBlocking(vo);
	}

	@Override
	public void InsertBlocking(BlockVO vo) {		
		blockDAO.InsertBlocking(vo);		
	}

	@Override
	public boolean IsBlocking(BlockVO vo) {
		return blockDAO.IsBlocking(vo);
	}
	
}
