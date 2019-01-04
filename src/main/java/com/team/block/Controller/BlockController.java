package com.team.block.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.block.Service.BlockService;
import com.team.block.VO.BlockVO;

@Controller
public class BlockController {

	@Autowired
	private BlockService blockService;


	@RequestMapping("/blockTest")
	public void BlockTest(Model model, HttpSession session) {
		//System.out.println( session.getAttribute("id"));
		
		
	}
	
	// 팔로우 버튼 눌렀을때.
	@RequestMapping("/block") 
	public String Block(@ModelAttribute BlockVO vo, Model model) {
		
		
		if(blockService.IsBlocking(vo)) {
			System.out.println("이미 팔로우 되어있음.");
			
		} else {
			blockService.InsertBlocking(vo);
		}

		
		return "BlockOk";
	}
	
	
	@RequestMapping("/unBlock")
	public String UnBlock(@ModelAttribute BlockVO vo, Model model) {
		
		if(blockService.IsBlocking(vo)) {
			blockService.DeleteBlocking(vo);
		}
		else {
			System.out.println("팔로우 되어있지 않음.");
		}
		
		
		return "unBlockOk";
		
	}
	
	
	@RequestMapping("/blockList")
	public String ShowBlockList(String id, Model model) {
		
		model.addAttribute("blockList", blockService.GetAllBlocker(id));
		model.addAttribute("blockingList", blockService.GetAllBlocking(id));
		
		
		
		return "BlockList";	
	
	}
	
	
}
