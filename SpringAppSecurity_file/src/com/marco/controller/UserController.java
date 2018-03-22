package com.marco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marco.pojo.User;
import com.marco.pojo.valid.SpringFormGroup;
import com.marco.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String showAdmin(Model model, @ModelAttribute("rdo") String rdo) {

		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("rdo", rdo);
		model.addAttribute("users", userService.findAll());
		return "user";
	}
	
	@RequestMapping("/user/save")
	public String register(@ModelAttribute("user") @Validated(value=SpringFormGroup.class) User user, 
			BindingResult result,
			Model model) {		
		
		if(result.hasErrors()) {			
			return "user";
		}
		
		userService.save(user);
		model.addAttribute("rdo", "User Saved");		
		return "redirect:/user";
	}
}
