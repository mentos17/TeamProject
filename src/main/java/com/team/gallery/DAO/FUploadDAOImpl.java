package com.team.gallery.DAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.gallery.VO.fileVO;


@Repository
public class FUploadDAOImpl implements FUploadDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(fileVO fvo) {
		// TODO Auto-generated method stub
		
		String[] Image = fvo.getGb_Image();
		int Num = fvo.getGb_Num();
		
		System.out.println(Image);
		
		Map<String, Object> paramMap = new HashMap<>();
		for(String s : Image) {
			paramMap.put("Image", s);
			paramMap.put("Num",Num);
			sqlSession.insert("fileInsert",paramMap);
		}
		
	}
}
