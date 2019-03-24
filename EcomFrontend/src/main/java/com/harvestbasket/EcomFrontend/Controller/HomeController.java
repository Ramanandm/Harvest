package com.harvestbasket.EcomFrontend.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value={"/","/home"})
	String sliderPage(Model model) {
		model.addAttribute("sliderPage", true);
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutPage(Model model) {
		model.addAttribute("aboutusPage", true);
		return "index";

	}

	@RequestMapping("/contactus")
	String contactusPage(Model model) {
		model.addAttribute("contactusPage", true);
		return "index";

	}

	@RequestMapping("/login")
	String loginPage(Model model) {
		model.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/register")
	String registerPage(Model model) {
		model.addAttribute("registerPage", true);
		return "index";
	}
}


