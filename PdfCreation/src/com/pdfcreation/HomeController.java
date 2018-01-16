package com.pdfcreation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HC--> no arg cons");
	}
	
	@RequestMapping("/")
	public String showWelcome() {
		System.out.println("HC--> showWelcome()");
		return "Welcome";
	}

}
