package com.team.gallery.DAO;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.gallery.VO.galleryVO;

@Repository
public class GalleryDAOImpl implements GalleryDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(galleryVO gvo) {
		// TODO Auto-generated method stub
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		gvo.setGb_Date(ts);
	
		sqlSession.insert("GalleryInsert", gvo);
	}
	
	@Override
	public int maxNum(galleryVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("maxNum",gvo);
	}

	@Override
	public List<galleryVO> GetMyGalleryList(String my_id) {
		
		return sqlSession.selectList("GetMyGalleryList", my_id);
	}

	@Override
	public List<galleryVO> GetSpecGalleryList(String id) {
		return sqlSession.selectList("GetSpecGalleryList", id);
	}
	
	
	
	
	
	
	
}
