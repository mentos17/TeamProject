package com.team.gallery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.gallery.DAO.GalleryDAO;
import com.team.gallery.VO.galleryVO;



@Service("GBService")
public class GBServiceImpl implements GBService {

	@Autowired
	private GalleryDAO gdao;
	
	@Override
	public void insert(galleryVO gvo) throws Exception{
		
		gdao.insert(gvo);
	
	}
	
	@Override
	public int maxNum(galleryVO gvo) {
		// TODO Auto-generated method stub
		return gdao.maxNum(gvo);
	}

	@Override
	public List<galleryVO> GetMyGalleryList(String my_id) {
		
		return gdao.GetMyGalleryList(my_id);
	}

	@Override
	public List<galleryVO> GetSpecGalleryList(String id) {
		return gdao.GetSpecGalleryList(id);
	}
	
	
	
	
}
