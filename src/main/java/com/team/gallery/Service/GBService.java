package com.team.gallery.Service;

import java.util.List;
import com.team.gallery.VO.galleryVO;


public interface GBService {
	public void insert(galleryVO gvo) throws Exception;

	// 최대 글 넘버 가져오기
	public int maxNum(galleryVO gvo);
	
	// 내가 쓴 글만 불러오기
	public List<galleryVO> GetMyGalleryList(String my_id);

	// 대상 id가 쓴글 불러오기.
	public List<galleryVO> GetSpecGalleryList(String id);

	
	
}
