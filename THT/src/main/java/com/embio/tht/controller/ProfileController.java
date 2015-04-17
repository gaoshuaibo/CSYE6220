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
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/view/restaurant", method = RequestMethod.GET)
	public String viewRestaurantProfile(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		if(r == null) return "redirect:/account/login/restaurant";
		model.addAttribute("restaurant", r);
		
		return "view_restaurant_profile";
	}
	
	@RequestMapping(value = "/view/user", method = RequestMethod.GET)
	public String viewUserProfile(
			@RequestParam(value="userid") Integer _userid,
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		model.addAttribute("user", ui);
		
		return "view_user_profile";
	}
}
