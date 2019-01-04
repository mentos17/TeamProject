package com.team.deal.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.deal.DTO.DealDTO;
import com.team.deal.Service.DealService;

@Controller
@RequestMapping("{id}/deal/*")
public class DealController {
	@Inject
	DealService dealService;
	//�۸��
	@RequestMapping("list")
	public String dealList(Model model) throws Exception{
		List<DealDTO> list =dealService.dealList();
		model.addAttribute("list", list);
		return "main.jsp?center=deal/deal_list";
	}

	//�۾�����������
	@RequestMapping("write")
	public String writePage() {
		return "main.jsp?center=deal/write";
	}
	//�۾���
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String dealWriter(DealDTO ddto) throws Exception{
		dealService.writerDeal(ddto);
		return "redirect:list";
	}
	
	//�� �� ����
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String dealRead(@RequestParam int DEAL_NUM,Model model) throws Exception{
		DealDTO data=dealService.dealRead(DEAL_NUM);
		model.addAttribute("data", data);
		return "deal/read";
	}
	
	//������������ �̵�
	@RequestMapping(value="updatepage",method=RequestMethod.GET)
	public String dealUpdate(@RequestParam int DEAL_NUM,Model model)throws Exception{
		DealDTO data = dealService.dealRead(DEAL_NUM);
		model.addAttribute("data",data);
		return "deal/update";
	}
	//�������Ѵ�
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String dealUpdateDo(DealDTO ddto)throws Exception{
		dealService.updateDeal(ddto);
		return "redirect:list";
	}
	//�Խñ� ����
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String dealDelte(@RequestParam int DEAL_NUM)throws Exception{
		dealService.deleteDeal(DEAL_NUM);
		return "redirect:list";
	}
	


}
