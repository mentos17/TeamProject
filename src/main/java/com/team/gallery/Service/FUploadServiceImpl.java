package com.team.gallery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.gallery.DAO.FUploadDAO;
import com.team.gallery.VO.fileVO;

@Service("FUploadService")
public class FUploadServiceImpl implements FUploadService{
	
	@Autowired
	private FUploadDAO fdao;
	
	@Override
	public void insert(fileVO fvo) throws Exception{
		
		fdao.insert(fvo);
	
	}
}
