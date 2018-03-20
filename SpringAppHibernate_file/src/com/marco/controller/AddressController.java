package com.marco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marco.pojo.Address;
import com.marco.pojo.Admin;
import com.marco.service.AddressService;
import com.marco.service.AdminService;

@Controller
@SessionAttributes("admin")
public class AddressController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping("/address/{idAdmin}")
	public String getAll(Model model, 
			@ModelAttribute("rdo") String rdo,
			@PathVariable("idAdmin") int id) {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);		
		model.addAttribute("rdo", rdo);		
		model.addAttribute("address", new Address());
		model.addAttribute("addresses", addressService.findAll(id));
		
				
		return "address";
	}

	@RequestMapping("/address/save")
	public String save(Model model, RedirectAttributes ra, 
			@ModelAttribute("address") Address address, @ModelAttribute("admin") Admin admin ) {
	
		addressService.save(admin, address);
		ra.addFlashAttribute("rdo", "Cambios realizados con éxito");
		
		return "redirect:/address/"+admin.getIdAdmin();
	}
	
}
