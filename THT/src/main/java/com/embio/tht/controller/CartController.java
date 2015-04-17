package com.embio.tht.controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.embio.tht.beans.*;
import com.embio.tht.common.Checker;
import com.embio.tht.common.DaoPool;
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public String cart(
			@RequestParam(value="userid") Integer _userid,
			Model model) {
		
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		model.addAttribute("user", ui);

		CartItemUnit ciu = new CartItemUnit();
		ciu.setUserInfoId(ui.getId());
		ciu.setPlaced(0);
		List<CartItemUnit> temps = DaoPool.getCartItemUnitDao().findByExample(ciu);
		List<CartItemUnit> items = new ArrayList<CartItemUnit>();
		
		for(CartItemUnit temp:temps){
			items.add(ModelFactory.getCartItemUnit(temp.getId()));
		}
		
		model.addAttribute("cart_items", items );
		
		return "view_user_cart";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(
			@RequestParam(value="userid") Integer _userid,
			@RequestParam(value="itemid") Integer _itemid,
			Model model) {
			UserInfo ui = Checker.isUserLoggedIn(_userid);
			
			CartItemUnit ciu = DaoPool.getCartItemUnitDao().findById(_itemid);
			DaoPool.getCartItemUnitDao().delete(ciu);

		return "redirect:/cart?userid=" + _userid;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addToCart(
			@RequestParam(value="userid", required=false) String _userid,
			@RequestParam(value="dishid") Integer _dishid,
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Integer quantity,
			Model model) {
		if(_userid == null){
			return "redirect:/account/login/user";
		}
		
		int userid = Integer.parseInt(_userid);
		UserInfo ui = Checker.isUserLoggedIn(userid);
		
		if(ui == null) return "redirect:/account/login/user";
		
		CartItemUnit ciu = new CartItemUnit();
		ciu.setDishId(_dishid);
		ciu.setQuantity(quantity);
		ciu.setRestaurantId(_restaurantid);
		ciu.setUserInfoId(ui.getId());
		ciu.setPlaced(0);
		
		DaoPool.getCartItemUnitDao().persist(ciu);
		
		return "redirect:/cart?userid=" + ui.getId();
	}
}
