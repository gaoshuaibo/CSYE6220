package com.embio.tht.controller;

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
			@RequestParam(value="userid") String _userid,
			Locale locale, 
			Model model) {
		if(_userid == null){
			return "login";
		}
		
		int userid = Integer.parseInt(_userid);
		UserInfo ui = Checker.isUserLoggedIn(userid);
		
		if(ui == null) return "login";
		model.addAttribute("user", ui);

		CartItemUnit ciu = new CartItemUnit();
		ciu.setUserInfoId(ui.getId());
		CartItemUnitHome ciudao = new CartItemUnitHome();
		List<CartItemUnit> items = ciudao.findByExample(ciu);
		
		
		for(CartItemUnit item:items){
			DishHome ddao = new DishHome();
			Dish dish = ddao.findById(item.getDishId());
			item.setDish(dish);
		}
		
		model.addAttribute("cart_items", items );
		
		return "cart";
	}
	
	@RequestMapping(value="/cart", method = RequestMethod.POST)
	public String remove(Locale locale, Model model) {

		return "cart";
	}
}
