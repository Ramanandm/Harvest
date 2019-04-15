package com.harvestbasket.EcomFrontend.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harvestbasket.EcomBackend.dao.AddressDao;
import com.harvestbasket.EcomBackend.model.Address;

@Controller
@RequestMapping("/user")
public class AddressController {

	@Autowired
	AddressDao addressdao;

	@RequestMapping("/address")
	String addressPage(Model model, HttpSession session) {
		model.addAttribute("addressPage", true);
		model.addAttribute("myaddress", new Address());
		model.addAttribute("Error1", false);
		model.addAttribute("Success", false);
		model.addAttribute("Error2", false);
		model.addAttribute("Error3", false);
		model.addAttribute("edit", false);
		model.addAttribute("address_list",
				addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
		return "index";
	}

	@RequestMapping("/addAddress")
	String insertAddressPage(@Valid @ModelAttribute("myaddress") Address address, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("addressPage", true);
			model.addAttribute("myaddress", address);
			model.addAttribute("Error1", true);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("address_list",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
			model.addAttribute("Error3", false);
			model.addAttribute("edit", false);

		}

		else {
			try {
				if (addressdao.createAddress(address)) {
					model.addAttribute("addressPage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", true);
					model.addAttribute("Error2", false);
					model.addAttribute("address_list",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("Error3", false);
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("addressPage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", false);
					model.addAttribute("Error2", false);
					model.addAttribute("address_list",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("Error3", true);
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("addressPage", true);
				model.addAttribute("myaddress", address);
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", true);
				model.addAttribute("address_list",
						addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
				model.addAttribute("Error3", false);
				model.addAttribute("edit", false);
			}

		}
		return "index";
	}

	@RequestMapping("/deleteAddress")
	String deleteAddressPage(@RequestParam("addrid") int addr_Id, Model model, HttpSession session) {
		try {
			if (addressdao.deleteAddress(addressdao.selectOneAddress(addr_Id)))
				return "redirect:/user/address";
			else {
				model.addAttribute("addressPage", true);
				model.addAttribute("myaddress", new Address());
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", false);
				model.addAttribute("address_list",
						addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
				model.addAttribute("Error3", true);
				model.addAttribute("edit", false);
				return "index";
			}

		} catch (Exception e) {
			model.addAttribute("addressPage", true);
			model.addAttribute("myaddress", new Address());
			model.addAttribute("Error1", false);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("address_list",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
			model.addAttribute("Error3", true);
			model.addAttribute("edit", false);
			return "index";

		}
	}

	@RequestMapping("/editAddress")
	String editAddressPage(@RequestParam("addrid") int addr_Id, Model model, HttpSession session) {
		model.addAttribute("addressPage", true);
		model.addAttribute("myaddress", addressdao.selectOneAddress(addr_Id));
		model.addAttribute("Error1", false);
		model.addAttribute("Success", false);
		model.addAttribute("Error2", false);
		model.addAttribute("address_list",
				addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
		model.addAttribute("Error3", false);
		model.addAttribute("edit", true);
		return "index";
	}

	@RequestMapping("/updateAddress")
	String updateAddressPage(@Valid @ModelAttribute("myaddress") Address address, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("addressPage", true);
			model.addAttribute("myaddress", address);
			model.addAttribute("Error1", true);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("address_list",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
			model.addAttribute("Error3", false);
			model.addAttribute("edit", false);

		}

		else {
			try {
				if (addressdao.updateAddress(address)) {
					model.addAttribute("addressPage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", true);
					model.addAttribute("Error2", false);
					model.addAttribute("address_list",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("Error3", false);
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("addressPage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", false);
					model.addAttribute("Error2", false);
					model.addAttribute("address_list",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("Error3", true);
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("addressPage", true);
				model.addAttribute("myaddress", address);
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", true);
				model.addAttribute("address_list",
						addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
				model.addAttribute("Error3", false);
				model.addAttribute("edit", false);
			}

		}
		return "index";
	}

}
	

