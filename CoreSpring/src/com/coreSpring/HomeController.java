package com.coreSpring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired //(more than one service impl + @qualifier)
	MessageService messageService;
	
	public HomeController() {
		System.out.println("In home controller--> no arg constructor");
	}

	@RequestMapping({"/"/*,"/home"*/})
	public String showHome() {
		System.out.println("In homeController--> showHome()");
		return "Home";
	}
	
	@RequestMapping("/showJoke")
	public String showJoke(Model model) {
		System.out.println("In homeController--> showJoke()");
		// get the joke from service
		String joke=messageService.showMessage();
		model.addAttribute("jokeOfTheDay", joke);
		return "DisplayJoke";
	}
	
	@RequestMapping("/openRegisterView")
	public String showRegisterView(Model model) {
		System.out.println("In home controller--> showRegisterView()");
		//store bean in model in reg lable
		RegBean bean=new RegBean();
		//bean.setUname("Balaji");
		model.addAttribute("reg", bean);
		return "Register";
	}
	@RequestMapping("/register")
	public String registerProcess(@ModelAttribute("reg") @Valid RegBean bean,BindingResult result) {
		System.out.println("In controller--> registerProcess()--> bean-->"+bean);
		if(result.hasErrors())
			return "Register";
		else {
			//invoke service and ask it to register bean.
			return "Success";
		}
	}
}


