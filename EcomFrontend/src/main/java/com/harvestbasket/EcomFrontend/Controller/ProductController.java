package com.harvestbasket.EcomFrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	void addimage(MultipartFile f, int id) {
		try {
			String path = "C:\\Users\\Sivasakthi\\eclipse-workspace\\EcomFrontend\\src\\main\\webapp\\resources\\productimages\\";
			path = path + String.valueOf(id) + ".jpeg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}	}	
	
	void deleteimage(int id) {
		try{
			String path ="C:\\Users\\Sivasakthi\\eclipse-workspace\\EcomFrontend\\src\\main\\webapp\\resources\\productimages";
		     path = path+String.valueOf(id)+".jpeg";
		     File x = new File(path);
		     if (x.exists()) {
		    	 x.delete();
		     }
		     Thread.sleep(5000);
		} catch (Exception e) {
	}

	}
	@RequestMapping("/seller/product")
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
	@RequestMapping("/viewproduct")
	String viewproductPage(Model model) {
		model.addAttribute("productlist", prodao.selectAllProducts());
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("viewproductPage",true);
		return "index";

	}
	@RequestMapping("/oneproduct")
     String oneproductpage(@RequestParam("productid") int productid,Model model) {
		model.addAttribute("myproduct",prodao.selectOneProducts(productid));
		model.addAttribute("oneproductpage",true);
		return "index";	
	}
	@RequestMapping("/selectbycat")
	String viewcatproductpage(@RequestParam("catid") int id,Model model) {
		model.addAttribute("productlist", prodao.selectCatProducts(id));
		model.addAttribute("categelist",catdao.selectAllCategories());
		model.addAttribute("viewproductPage",true);
		return "index";
	}
	@RequestMapping("/seller/addproduct")
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
					addimage(p.getPimage(), p.getProductid());
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
		model.addAttribute("editmode",false);
		return "index";

	}

	@RequestMapping("/seller/deleteproduct")
	String deleteProduct(@RequestParam("productid") int productid, Model model) {
		if (prodao.deleteProduct(productid)) {
			deleteimage(productid);
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

	@RequestMapping("/seller/editproduct")
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
	
	@RequestMapping("/seller/updateproduct")
	String updateProduct(@Valid @ModelAttribute("proobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("proobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");

			} else {
				if (prodao.updateProduct(p)) {
					addimage(p.getPimage(), p.getProductid());
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




