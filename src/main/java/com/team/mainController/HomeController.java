package com.team.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController{
	@RequestMapping(value = "main", method = RequestMethod.POST)
	public String main(Model model) {
		return "main";
	}	
}
