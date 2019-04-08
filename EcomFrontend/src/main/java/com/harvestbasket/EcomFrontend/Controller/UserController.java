package com.harvestbasket.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harvestbasket.EcomBackend.dao.UserDao;
import com.harvestbasket.EcomBackend.model.User;

@Controller
public class UserController {
    	@Autowired 
		UserDao userdao;
    	
		@RequestMapping("/register")
		String sellerPage(Model model) {
			model.addAttribute("userobject", new User());
			model.addAttribute("userlist", userdao.selectAllUser());
			model.addAttribute("registerPage",true);
			model.addAttribute("Success", false);
			model.addAttribute("Error1", false);
			model.addAttribute("Error2", false);//user already exists
			return "index";
		
		}
		@RequestMapping("/adduser")
		String addUser(@Valid @ModelAttribute("userobject")User u,BindingResult bindingResult, Model model) {
			try {
				if(bindingResult.hasErrors())
				{
					model.addAttribute("userobject",u);
					model.addAttribute("error",true);
					model.addAttribute("Success", false);
					model.addAttribute("Error1", true);
					model.addAttribute("Error2", false);//user already exists
				}
				else
				{
					BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
					u.setPassword(passwordEncoder.encode(u.getPassword()));
					if(userdao.insertUser(u))
					{
						model.addAttribute("userobject", new User());
						model.addAttribute("Success", true);
						model.addAttribute("Error1", false);
						model.addAttribute("Error2", false); //user already exists

					}
					else
					{
						model.addAttribute("error",true);
						model.addAttribute("message","pls try after sometimes");
						model.addAttribute("sellobject",u);
					}
				}
			}
			catch(Exception e)
			{
				model.addAttribute("userobject",u);
				model.addAttribute("error",true);
				model.addAttribute("Success", false);
				model.addAttribute("Error1", false);
				model.addAttribute("Error2", true);//user already exists
			}
			model.addAttribute("registerPage",true);
			model.addAttribute("userlist", userdao.selectAllUser());
			return "index";

		}

	}


