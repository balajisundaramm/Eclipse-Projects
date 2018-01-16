package com.uttara.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	MVCService service;
	
	public HomeController() {
		System.out.println("HC->no-arg constr");
	}
	
	@RequestMapping({"/","/home"})
	public String showHome()
	{
		
		System.out.println("in HC->showHome()");
		
		return "Home";
	}
	
	@RequestMapping("/openInputView")
	public String showInput(Model model)
	{
		System.out.println("in HC->showInput()");
		
		//save a bean in Model for pre-population
		
		InputBean bean = new InputBean();
//		bean.setUname("Ramu");
//		bean.setAge(30);
		
		model.addAttribute("input",bean);
		
		return "Input";
	}
	
	@RequestMapping("/welcome")
	public String showWelcome(@ModelAttribute("input") @Valid InputBean bean,BindingResult result, Model model)
	{
		System.out.println("in HC->showWelcome() uname = "+bean.getUname()+" age = "+bean.getAge());
		if(result.hasErrors())
		{
			System.out.println("HC->showWelcome() bean validation has failed");
			return "Input";
		}
		else
		{
			System.out.println("HC->showWelcome() validation has succeeded");
			System.out.println("HC->showWelcome() going to invoke service method");
			String msg = service.getWelcomeMessage(bean);
			System.out.println("HC->showWelcome() returning from service method msg = "+msg);
			model.addAttribute("message",msg);
			return "Welcome";
		}
		
	}
}





