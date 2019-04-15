package com.harvestbasket.EcomFrontend.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harvestbasket.EcomBackend.dao.CartDao;
import com.harvestbasket.EcomBackend.dao.ProductDao;
import com.harvestbasket.EcomBackend.dao.UserDao;
import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.Product;
import com.harvestbasket.EcomBackend.model.User;

@Controller
public class CartController {
	@Autowired
	ProductDao productdao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	CartDao cartdao;
	
	@RequestMapping("/addtocart")
	String addToCart(HttpSession httpSession, @RequestParam("pid") int proid) {
		if (httpSession.getAttribute("emailid") != null) {
			Cart cart = new Cart();
			Product product = productdao.selectOneProduct(proid);
			User user = userdao.selectOneUser(httpSession.getAttribute("emailid").toString());
			System.out.println(user.getCname());
			List<Cart> cartlist = cartdao.selectAllCarts(user);
			System.out.println(cartlist.toString());
			if (cartlist.isEmpty()) {
			
				cart.setUser(user);
				cart.setProduct(product);
				cart.setQuantity(1);
				cart.setSubtotal(product.getProductprice());
				cartdao.insertCart(cart);
				
				return "redirect:/user/viewcart";
				
		} else {
				Iterator<Cart> iterator = cartlist.listIterator();
				while (iterator.hasNext()) {
					Cart cart2 = (Cart) iterator.next();
					Product p=cart2.getProduct();
					if (p.getProductid()==proid) {
						int qty = cart2.getQuantity();
						qty++;
						cart2.setQuantity(qty);
						cart2.setSubtotal(qty * product.getProductprice());
						cartdao.updateCart(cart2);
						return "redirect:/user/viewcart";
					}
				}
				cart.setUser(user);
				cart.setProduct(product);
				cart.setQuantity(1);
				cart.setSubtotal(product.getProductprice());
				cartdao.insertCart(cart);
				return "redirect:/user/viewcart";
			}

		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping("/user/viewcart")
	String viewCart(Model model,HttpSession httpSession)
	{
		float tot=0;
		model.addAttribute("addtocartPage",true);
		ArrayList<Cart> cartList=(ArrayList<Cart>) cartdao.selectAllCarts(userdao.selectOneUser(httpSession.getAttribute("emailid").toString()));
		System.out.println(cartList.toString());
		Iterator<Cart> iterator=cartList.listIterator();
		while (iterator.hasNext()) {
			Cart cart = (Cart) iterator.next();
			tot=tot+cart.getSubtotal();
		}
		model.addAttribute("cartitems",cartList);
		model.addAttribute("total",tot);

		return "index";
	}
	@RequestMapping("/user/deleteCartItem")
	String deleteCartItem(@RequestParam("itemid") int id) {
		cartdao.deleteCart(id);
		return "redirect:/user/viewcart";
	}

}



	