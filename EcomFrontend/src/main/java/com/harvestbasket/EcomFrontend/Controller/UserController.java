package com.harvestbasket.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
			model.addAttribute("error",false);
			model.addAttribute("message","");
			model.addAttribute("success",false);
			return "index";

		}
		@RequestMapping("/adduser")
		String addUser(@Valid @ModelAttribute("userobject")User u,BindingResult bindingResult, Model model) {
			try {
				Object c;
				if(bindingResult.hasErrors())
				{
					model.addAttribute("userobject",u);
					model.addAttribute("error",true);
					model.addAttribute("message","Inapproprite data");
			
				}
				else
				{
					if(userdao.insertUser(u))
					{
						model.addAttribute("userobject", new User());
						model.addAttribute("success",true);

					}
					else
					{
						model.addAttribute("userobject", new User());
						model.addAttribute("message","pls try after sometimes");
						model.addAttribute("sellobject",u);
					}
				}
			}
			catch(Exception e)
			{
				model.addAttribute("userobject",u);
				model.addAttribute("error",true);
				model.addAttribute("message","duplicate data");
			}
			model.addAttribute("registerPage",true);
			model.addAttribute("userlist", userdao.selectAllUser());
			return "index";

		}

	}


