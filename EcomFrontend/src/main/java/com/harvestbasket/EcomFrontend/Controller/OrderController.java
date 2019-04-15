package com.harvestbasket.EcomFrontend.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harvestbasket.EcomBackend.dao.AddressDao;
import com.harvestbasket.EcomBackend.dao.CartDao;
import com.harvestbasket.EcomBackend.dao.MyOrderDao;
import com.harvestbasket.EcomBackend.dao.ProductDao;
import com.harvestbasket.EcomBackend.dao.UserDao;
import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.MyOrder;
import com.harvestbasket.EcomBackend.model.Product;

@Controller
@RequestMapping("/user")
public class OrderController {
	@Autowired
	CartDao cartdao;

	@Autowired
	AddressDao adddao;

	@Autowired
	UserDao userdao;

	@Autowired
	ProductDao prodao;

	@Autowired
    MyOrderDao myorderdao;
	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam("addressid") int addid, Model model, HttpSession httpSession) {
		MyOrder oMyorder = new MyOrder();
		ArrayList<Cart> carts = (ArrayList<Cart>) cartdao.selectAllCarts(userdao.selectOneUser(httpSession.getAttribute("userid").toString()));
		Iterator<Cart> iterator = carts.iterator();
		while (iterator.hasNext()) {
			Date d = new Date();
			long id = UUID.randomUUID().getMostSignificantBits();
			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));
			Cart cart = (Cart) iterator.next();
			Product p=prodao.selectOneProduct(cart.getProduct().getProductid());
			if (p.getProductstock() >= cart.getQuantity()) 
			{
				oMyorder.setAddress(adddao.selectOneAddress(addid));
				oMyorder.setOrderid(oid);
				oMyorder.setOrderDate(d);
				oMyorder.setQuantity(cart.getQuantity());
				oMyorder.setProduct(cart.getProduct());
				oMyorder.setSubtotal(cart.getSubtotal());
				oMyorder.setUser(userdao.selectOneUser(httpSession.getAttribute("useremail").toString()));
				int qty=p.getProductstock() - cart.getQuantity();
				p.setProductstock(qty);
				if(myorderdao.insertMyOrder(oMyorder))
				{
					prodao.updateProduct(p);
					cartdao.deleteCart(cart);
				}
			}
		}
		ArrayList<Cart> cart = (ArrayList<Cart>) cartdao.selectAllCarts(userdao.selectOneUser(httpSession.getAttribute("userid").toString()));
		httpSession.setAttribute("itemcount",carts.size());
		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(Integer.parseInt(httpSession.getAttribute("userid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}
	
	@RequestMapping("/vieworders")
	String viewallorders(Model model,HttpSession httpSession)
	{
		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(Integer.parseInt(httpSession.getAttribute("userid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}
	

	@RequestMapping("/receipt")
	String receipt(@RequestParam("rid")String oid,Model model,HttpSession httpSession)
	
	{
		model.addAttribute("order", myorderdao.selectOneMyOrder(oid));
		model.addAttribute("receiptpage", true);
		return "index";
		
	}

}
	
	

