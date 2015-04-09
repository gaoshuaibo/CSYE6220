package com.embio.tht.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
@RequestMapping(value="/viewdish")
public class ViewDishController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String viewdish(
			@RequestParam(value="userid", required=false) String _userid,
			@RequestParam(value="dishid") int _dishid,
			Model model) {
		if(_userid == null){
			return "login";
		}
		
		int userid = Integer.parseInt(_userid);
		UserInfo ui = Checker.isUserLoggedIn(userid);
		model.addAttribute("user", ui );
		
		DishHome ddao = new DishHome();
		Dish dish = ddao.findById(_dishid);
		model.addAttribute("dish", dish );
		
		RestaurantHome rdao = new RestaurantHome();
		Restaurant restaurant = rdao.findById(dish.getRestaurantId());
		model.addAttribute("restaurant", restaurant );
		
		LocationHome ldao = new LocationHome();
		Location location = ldao.findById(restaurant.getLocationId());
		model.addAttribute("location", location );

		return "viewdish";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToCart(
			@RequestParam(value="userid") String _userid,
			@RequestParam(value="dishid") Integer _dishid,
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Integer quantity,
			Model model) {
		if(_userid == null){
			return "login";
		}
		
		int userid = Integer.parseInt(_userid);
		UserInfo ui = Checker.isUserLoggedIn(userid);
		
		if(ui == null) return "login";
		
		CartItemUnit ciu = new CartItemUnit();
		ciu.setDishId(_dishid);
		ciu.setQuantity(quantity);
		ciu.setRestaurantId(_restaurantid);
		ciu.setUserInfoId(ui.getId());
		
		CartItemUnitHome ciudao = new CartItemUnitHome();
		ciudao.persist(ciu);
		
		return "redirect:/cart?userid=" + ui.getId();
	}
}
