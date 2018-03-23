package com.marco;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/")
	public String test() {
		return "API RESTful funcionando ....";
	}
	
}
