package com.embio.tht.controller;

import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.embio.tht.beans.*;
import com.embio.tht.common.Checker;
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getView(
			Model model) {

		String role = ModelFactory.getCurrentRole();
		
		if(role.equals("ANONYMOUS"))
			return "redirect:welcome_login";
		else if(role.equals("ROLE_CUSTOMER")){
			Customer customer = ModelFactory.getCurrentCustomer();
			model.addAttribute("user",customer);
			return "view_user_home";}
		else if(role.equals("ROLE_RESTAURANT")){
			Restaurant restaurant = ModelFactory.getCurrentRestaurant();
			model.addAttribute("restaurant",restaurant);
			return "view_restaurant_home";}
		return "redirect:welcome_login";
	}
}
