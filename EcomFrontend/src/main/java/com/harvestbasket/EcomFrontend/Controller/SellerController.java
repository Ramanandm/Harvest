package com.harvestbasket.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harvestbasket.EcomBackend.dao.SellerDao;
import com.harvestbasket.EcomBackend.model.Seller;

@Controller
public class SellerController {
	@Autowired 
	SellerDao selldao;
	@RequestMapping("/sellerregister")
	String sellerPage(Model model) {
		model.addAttribute("sellobject", new Seller());
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		model.addAttribute("sellerPage",true);
		model.addAttribute("error",false);
		model.addAttribute("message","");
		model.addAttribute("success",false);
		return "index";

	}
	@RequestMapping("/addseller")
	String addSeller(@Valid @ModelAttribute("sellobject")Seller c,BindingResult bindingResult, Model model) {
		try {
			Object s;
			if(bindingResult.hasErrors())
			{
				model.addAttribute("sellobject",c);
				model.addAttribute("error",true);
				model.addAttribute("message","Inapproprite data");
		
			}
			else
			{
				BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
				c.setSellerpassword(passwordEncoder.encode(c.getSellerpassword()));
				if(selldao.insertSeller(c))
				{
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("success",true);

				}
				else
				{
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("message","pls try after sometimes");
					model.addAttribute("sellobject",c);
				}
			}
		}
		catch(Exception e)
		{
			model.addAttribute("sellobject",c);
			model.addAttribute("error",true);
			model.addAttribute("message","duplicate data");
		}
		model.addAttribute("sellerPage",true);
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		return "index";

	}

}
	

