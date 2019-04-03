package com.harvestbasket.EcomFrontend.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {

	@RequestMapping("/login")
	String loginPage(Model model) {
		model.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/flogin")
	String floginPage(Model model) {
		model.addAttribute("error",true);
		model.addAttribute("loginPage", true);
		return "index";
	}
	@RequestMapping("/loginsuccess")
	String loginsuccessPage(Model model) {
		model.addAttribute("sliderPage", true);
		return "index";
	}
}

