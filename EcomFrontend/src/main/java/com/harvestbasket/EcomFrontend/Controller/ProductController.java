package com.harvestbasket.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harvestbasket.EcomBackend.dao.CategoryDao;
import com.harvestbasket.EcomBackend.dao.ProductDao;
import com.harvestbasket.EcomBackend.dao.SellerDao;
import com.harvestbasket.EcomBackend.model.Category;
import com.harvestbasket.EcomBackend.model.Product;
import com.harvestbasket.EcomBackend.model.Seller;

@Controller
public class ProductController {
	@Autowired 
	ProductDao prodao;
	@Autowired
	CategoryDao catdao;
	@Autowired 
	SellerDao selldao;
	
	@RequestMapping("/product")
	String productPage(Model model) {
		model.addAttribute("proobject", new Product());
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("selllist",selldao.selectAllSellers());
		model.addAttribute("productPage",true);
		model.addAttribute("success", false);
		model.addAttribute("editmode", false);
		return "index";

	}
	@RequestMapping("/addproduct")
	String addproduct(@Valid @ModelAttribute("proobject")Product p,BindingResult bindingResult, Model model) {
		try {
			if(bindingResult.hasErrors())
			{
				model.addAttribute("proobject",p);
				model.addAttribute("error",true);
				model.addAttribute("message","Inapproprite data");
		
			}
			else
			{
				if(prodao.insertProduct(p))
				{
					model.addAttribute("proobject", new Product());
					model.addAttribute("success",true);

				}
				else
				{
					model.addAttribute("proobject", new Product());
					model.addAttribute("message","pls try after sometimes");
					model.addAttribute("proobject",p);
				}
			}
		}
		catch(Exception e)
		{
			model.addAttribute("proobject",p);
			model.addAttribute("error",true);
			model.addAttribute("message","duplicate data");
		}
		model.addAttribute("productPage",true);
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("selllist",selldao.selectAllSellers());
		return "index";

	}

	@RequestMapping("/deleteproduct")
	String deleteProduct(@RequestParam("productid") int productid, Model model) {
		if (prodao.deleteProduct(productid)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "Pls try After Sometime");
		}
		model.addAttribute("proobject", new Product());
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("selllist",selldao.selectAllSellers());
		model.addAttribute("editmode",false);
		return "index";

	}

	@RequestMapping("/editproduct")
	String editProduct(@RequestParam("productid") int productid, Model model) {
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("proobject",prodao.selectOneProducts(productid));
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("selllist",selldao.selectAllSellers());
		return "index";

	}
	
	@RequestMapping("/updateproduct")
	String updateProduct(@Valid @ModelAttribute("proobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("proobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");

			} else {
				if (prodao.updateProduct(p)) {
					model.addAttribute("proobject", new Product());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "Pls try After Sometime");
					model.addAttribute("proobject", p);
				}
			}
		} catch (Exception e) {
			model.addAttribute("proobject", p);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("selllist",selldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";
	}
}




