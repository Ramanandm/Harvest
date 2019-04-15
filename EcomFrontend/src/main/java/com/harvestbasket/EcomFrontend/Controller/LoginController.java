package com.harvestbasket.EcomFrontend.Controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harvestbasket.EcomBackend.dao.SellerDao;
import com.harvestbasket.EcomBackend.dao.UserDao;
import com.harvestbasket.EcomBackend.model.Seller;
import com.harvestbasket.EcomBackend.model.User;

@Controller
public class LoginController {
	@Autowired
	UserDao userdao;
	
	@Autowired
	SellerDao sellerdao;

	@RequestMapping("/login")
	String loginPage(Model model) {
		model.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/flogin")
	String floginPage(Model model) {
		model.addAttribute("error", true);
		model.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/loginsuccess")
	String loginnsuccess(Model model, HttpSession httpSession)
	{
		String emailid = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_USER")) {
				User user = userdao.selectOneUser(emailid);
				httpSession.setAttribute("username", user.getCname());
				httpSession.setAttribute("userid", user.getCusid());
				httpSession.setAttribute("emailid", user.getEmailid());
				httpSession.setAttribute("userloggedin", true);
				model.addAttribute("sliderPage", true);
			} else if(authority.getAuthority().equals("ROLE_SELLER"))
			{
				Seller seller =sellerdao.selectOneSellers(emailid);
				httpSession.setAttribute("sellerloggedin", true);
				model.addAttribute("sliderPage", true);
			}
			else {
				httpSession.setAttribute("username", "ADMINISTRATOR");
				httpSession.setAttribute("adminloggedin", true);
				model.addAttribute("sliderPage", true);
			}

		}
		return "index";

	}
}
