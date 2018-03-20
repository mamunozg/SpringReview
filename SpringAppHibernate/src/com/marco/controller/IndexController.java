package com.marco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("rdo")
public class IndexController {

	@RequestMapping("/")	
	public String showIndex(Model model) {		
		model.addAttribute("rdo", "Resultado desde la sesion");
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "about";
	}
	

	
	
	
}
