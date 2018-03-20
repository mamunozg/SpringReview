package com.marco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marco.pojo.Admin;
import com.marco.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("rdo") String rdo ) {
		
		List<Admin> lAdmin = adminService.findAll();
		
		
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("rdo", rdo);
		
		System.out.println("Ha recuperado " + lAdmin.size());
		
		model.addAttribute("admins", lAdmin);
		
		return "admin";
	}

	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, 
			RedirectAttributes ra  
			//,@RequestParam("estado") String estado
			) {
			
		
		
//		System.out.println(adminForm);
//		System.out.println("Request param: " + estado);
//		model.addAttribute("adminForm", adminForm);

		if(adminService.saveOrUpdate(adminForm)) {
			ra.addFlashAttribute("rdo", "Cambios realizados con exito");
		}
		else {
			ra.addFlashAttribute("rdo", "No se han realizado los cambios");
		}
		
		
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/{idAdmin}/update")
	public String showUpdate(Model model, @PathVariable("idAdmin") int id) {
		
		Admin admin = adminService.findById(id);
		if(admin != null) {
			model.addAttribute("admin", admin);
			model.addAttribute("admins", adminService.findAll());
		}
		
		return "admin"; 		
	}
	
	@RequestMapping("/admin/{idAdmin}/delete")
	public String delete(@PathVariable("idAdmin")  int id, RedirectAttributes ra, Model model) {
		if(adminService.delete(id)) {
			ra.addFlashAttribute("rdo", "Cambios realizados con exito");
		}
		else {
			ra.addFlashAttribute("rdo", "Se ha producido un error al eliminar");
		}
		return "redirect:/admin";
	}
	
}
