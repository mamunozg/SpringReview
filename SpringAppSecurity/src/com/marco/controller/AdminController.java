package com.marco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marco.pojo.Admin;
import com.marco.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("rdo") String rdo) {

		List<Admin> lAdmin = adminService.findAll();

		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("rdo", rdo);

		if(lAdmin != null) {
			System.out.println("Ha recuperado " + lAdmin.size());
		}

		model.addAttribute("admins", lAdmin);

		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {

		adminService.saveOrUpdate(adminForm);
		ra.addFlashAttribute("rdo", "Cambios realizados con exito");
		
		return "redirect:/admin";
	}

	@RequestMapping("/admin/{idAdmin}/update")
	public String showUpdate(Model model, @PathVariable("idAdmin") int id) {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		model.addAttribute("admins", adminService.findAll());
		
		return "admin";
	}

	@RequestMapping("/admin/{idAdmin}/delete")
	public String delete(@PathVariable("idAdmin") int id, RedirectAttributes ra, Model model) {
		adminService.delete(id);
		ra.addFlashAttribute("rdo", "Cambios realizados con exito");		
		return "redirect:/admin";
	}

	@RequestMapping(value="/admin/json/search", produces="application/json")
	@ResponseBody
	public Map<String, Object> findAllLikeName(@RequestParam("term") String name) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Admin> admins = adminService.findAllLikeName(name);
		
		for(int i=0;i<admins.size();i++) {
			Admin admin = admins.get(i);
			map.put("name"+ i, admin.getIdAdmin() + " " + admin.getName());
		}
		
		System.out.println(map.toString());
		return map;		
	}
}
