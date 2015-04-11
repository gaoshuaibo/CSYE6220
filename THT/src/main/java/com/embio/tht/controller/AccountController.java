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
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login/user", method=RequestMethod.GET)
	public String getUserLoginForm(
			@RequestParam(value="go_to_welcome", required = false) Integer _go_to_welcome,
			Model model) {
		
		model.addAttribute("role", "user");
		
		if(_go_to_welcome != null)
			model.addAttribute("go_to_welcome", _go_to_welcome);
		
		return "view_login";
	}

	@RequestMapping(value = "/login/restaurant", method=RequestMethod.GET)
	public String getRestaurantLoginForm(
			@RequestParam(value="go_to_welcome", required = false) Integer _go_to_welcome,
			Model model) {
		model.addAttribute("role", "restaurant");
		
		if(_go_to_welcome != null)
			model.addAttribute("go_to_welcome", _go_to_welcome);
		
		return "view_login";
	}
	
	@RequestMapping(value = "/login/user", method = RequestMethod.POST)
	public String userlogin(
			@RequestParam(value="go_to_welcome", required = false) Integer _go_to_welcome,
			String username,
			String password) {
		
		AccountInfo search = new AccountInfo();
		search.setAccountName(username);
		search.setPassword(password);
		AccountInfoHome aidao = new AccountInfoHome();
		AccountInfo ai = aidao.findFirstByExample(search);
		if(ai == null)
		{
			return "redirect:/account/login/user";
		}
		ai.setIsLoggedIn(1);
		aidao.attachDirty(ai);
		
		UserInfoHome uidao = new UserInfoHome();
		UserInfo search1 = new UserInfo();
		search1.setAccountId(ai.getId());
		UserInfo ui = uidao.findFirstByExample(search1);
		
		if(_go_to_welcome == null)
			return "redirect:/user?userid=" + ui.getId();
		else
			return "redirect:/welcome?userid="+ui.getId();
	}
	
	@RequestMapping(value = "/login/restaurant", method = RequestMethod.POST)
	public String restaurantlogin(
			@RequestParam(value="go_to_welcome", required = false) Integer _go_to_welcome,
			String username,
			String password) {
		
		AccountInfo search = new AccountInfo();
		search.setAccountName(username);
		search.setPassword(password);
		AccountInfoHome aidao = new AccountInfoHome();
		AccountInfo ai = aidao.findFirstByExample(search);
		if(ai == null)
		{
			return "redirect:/account/login/restaurant";
		}
		ai.setIsLoggedIn(1);
		aidao.attachDirty(ai);
		
		RestaurantHome rdao = new RestaurantHome();
		Restaurant search1 = new Restaurant();
		search1.setAccountId(ai.getId());
		Restaurant r = rdao.findFirstByExample(search1);
		
		if(_go_to_welcome == null)
			return "redirect:/restaurant?restaurantid="+r.getId();
		else
			return "redirect:/welcome";
	}
}
