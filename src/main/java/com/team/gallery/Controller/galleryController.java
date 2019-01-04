package com.team.gallery.Controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.gallery.Service.FUploadService;
import com.team.gallery.Service.GBService;
import com.team.gallery.VO.fileVO;
import com.team.gallery.VO.galleryVO;
import com.team.gallery.util.IPUtill;
import com.team.gallery.util.UploadUtil;
import com.team.member.VO.MemberVO;


@Controller
public class galleryController {
	
	private static final Logger logger = LoggerFactory.getLogger(galleryController.class);
	
	@Autowired
	private GBService gbService;
	
	@Autowired
	private FUploadService fuService;
	
	
	@RequestMapping(value = "imgupload", method=RequestMethod.GET)
	public String imgupload() {
		
		return "main.jsp?center=gallery/imgupload";
	}
	
	@RequestMapping("/galleryWrite")
	public String galleryWrite(@ModelAttribute galleryVO gvo,fileVO fvo, RedirectAttributes ra, HttpServletRequest request) throws Exception {
		
				
		gvo.setGb_IP(IPUtill.getClientIpAddr(request));
		
		gbService.insert(gvo);
		
		int Num = gbService.maxNum(gvo);
		
		fvo.setGb_Num(Num);
		
		fuService.insert(fvo);
		
		ra.addFlashAttribute("msg", "success");
		
		return "redirect:main";
	}
	
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@ResponseBody
	@RequestMapping(value="gallery/imgupload", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ResponseEntity<String> imgupload(MultipartFile file, HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		
		try {
			String saveFilePath = UploadUtil.uplaodFile(file, request);
			entity = new ResponseEntity<>(saveFilePath,HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value ="/display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName,HttpServletRequest request) throws Exception{
		
		HttpHeaders header = UploadUtil.getHttpHeaders(fileName);
		String rootPath = UploadUtil.getRootPath(fileName, request);
		
				
		ResponseEntity<byte[]> entity = null;
		
		try (InputStream is = new FileInputStream(rootPath+fileName)){
			entity = new ResponseEntity<>(IOUtils.toByteArray(is),header,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "gallery/delete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteImage (String fileName, HttpServletRequest request) {
		
				
		ResponseEntity<String> entity = null;
		
		try {
			UploadUtil.deleteFile(fileName, request);
			entity = new ResponseEntity<>("DELETED",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
	// 갤러리 접근 처리.
	@RequestMapping(value = "{id}/gallery")
	public String ShowGallery(@PathVariable String id, Model model, HttpServletRequest request) {
		//System.out.println("ShowGallery 호출");
		
		// id에 해당하는 프로필을 가져온다. 
		// MemberInterceptor에서 처리 한 후 가져오는것.
		MemberVO memberVo = (MemberVO)request.getAttribute("vo");
		model.addAttribute("profile",memberVo);
		model.addAttribute("isMyGall" , false);
		model.addAttribute("pageid", id);
		
		return "main.jsp?center=gallery/list";
	}
	
	// {id} 에 해당하는 사용자가 쓴 글을 가져온다.
	@RequestMapping(value = "{id}/getSpecGallery")
	@ResponseBody
	public List<galleryVO> GetSpecGallery(@PathVariable String id, Model model) {
		//System.out.println("GetSpecGallery 호출 " + id);
		List<galleryVO> vo = gbService.GetSpecGalleryList(id);

		return vo;
	}
	
	// 내가 팔로우 한 사람들의 글을 가져옴.
	@RequestMapping(value = "{id}/getMyGallery")
	@ResponseBody
	public List<galleryVO> GetMyGallery(@PathVariable String id, Model model) {
		//System.out.println("GetMyGallery 호출 " + id);
		List<galleryVO> vo = gbService.GetMyGalleryList(id);

		/*for (galleryVO vv : vo) {
			System.out.println("ShowGallery " + vv.getGb_Content() + " " + vv.getMb_ID() + " " + vv.getGb_Date());
		}*/

		return vo;
	}
}
