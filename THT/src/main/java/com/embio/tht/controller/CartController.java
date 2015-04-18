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
			Model model) {
		
		Customer customer = ModelFactory.getCurrentCustomer();

		model.addAttribute("user",customer);

		CartItemUnit ciu = new CartItemUnit();
		ciu.setUserInfoId(customer.getId());
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
			@RequestParam(value="itemid") Integer _itemid,
			Model model) {
			
			CartItemUnit ciu = DaoPool.getCartItemUnitDao().findById(_itemid);
			DaoPool.getCartItemUnitDao().delete(ciu);

		return "redirect:/cart";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addToCart(
			@RequestParam(value="dishid") Integer _dishid,
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Integer quantity,
			Model model) {
		Customer customer = ModelFactory.getCurrentCustomer();
		
		CartItemUnit ciu = new CartItemUnit();
		ciu.setDishId(_dishid);
		ciu.setQuantity(quantity);
		ciu.setRestaurantId(_restaurantid);
		ciu.setUserInfoId(customer.getId());
		ciu.setPlaced(0);
		
		DaoPool.getCartItemUnitDao().persist(ciu);
		
		return "redirect:/cart";
	}
}
