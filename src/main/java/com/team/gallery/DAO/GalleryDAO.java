package com.team.gallery.DAO;

import java.util.List;

import com.team.gallery.VO.galleryVO;
import com.team.member.VO.MemberVO;

public interface GalleryDAO {

	public void insert(galleryVO gvo);

	// gallery/list.jsp 에 출력할 정보 얻어오기
	public List<galleryVO> GetMyGalleryList(String my_id);

	public List<galleryVO> GetSpecGalleryList(String id);

	public int maxNum(galleryVO gvo);
	
}
