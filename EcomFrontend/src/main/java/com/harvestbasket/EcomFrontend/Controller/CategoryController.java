package com.harvestbasket.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harvestbasket.EcomBackend.dao.CategoryDao;
import com.harvestbasket.EcomBackend.model.Category;
@Controller
public class CategoryController {
	@Autowired
	CategoryDao catdao;
	
	@RequestMapping("/category")
	String categoryPage(Model model) {
		model.addAttribute("catobject", new Category());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("categoryPage",true);
		model.addAttribute("error",false);
		model.addAttribute("message","");
		model.addAttribute("success",false);
		return "index";

	}

	@RequestMapping("/addcategory")
	String addCategory(@Valid @ModelAttribute("catobject")Category c,BindingResult bindingResult, Model model) {
		try {
			if(bindingResult.hasErrors())
			{
				model.addAttribute("catobject",c);
				model.addAttribute("error",true);
				model.addAttribute("message","Inapproprite data");
		
			}
			else
			{
				if(catdao.insertCategory(c))
				{
					model.addAttribute("catobject", new Category());
					model.addAttribute("success",true);

				}
				else
				{
					model.addAttribute("catobject", new Category());
					model.addAttribute("message","pls try after sometimes");
					model.addAttribute("catobject",c);
				}
			}
		}
		catch(Exception e)
		{
			model.addAttribute("catobject",c);
			model.addAttribute("error",true);
			model.addAttribute("message","duplicate data");
		}
		model.addAttribute("categoryPage",true);
		model.addAttribute("categorylist", catdao.selectAllCategories());
		return "index";

	}

}
