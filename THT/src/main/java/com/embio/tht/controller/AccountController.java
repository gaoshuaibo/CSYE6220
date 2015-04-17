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
import com.embio.tht.common.DaoPool;
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
		AccountInfo ai = DaoPool.getAccountInfoDao().findFirstByExample(search);
		if(ai == null)
		{
			return "redirect:/account/login/user";
		}
		ai.setIsLoggedIn(1);
		DaoPool.getAccountInfoDao().attachDirty(ai);
		
		UserInfo search1 = new UserInfo();
		search1.setAccountId(ai.getId());
		UserInfo ui = DaoPool.getUserInfoDao().findFirstByExample(search1);
		
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
		AccountInfo ai = DaoPool.getAccountInfoDao().findFirstByExample(search);
		if(ai == null)
		{
			return "redirect:/account/login/restaurant";
		}
		ai.setIsLoggedIn(1);
		DaoPool.getAccountInfoDao().attachDirty(ai);
		
		Restaurant search1 = new Restaurant();
		search1.setAccountId(ai.getId());
		Restaurant r = DaoPool.getRestaurantDao().findFirstByExample(search1);
		
		if(_go_to_welcome == null)
			return "redirect:/restaurant?restaurantid="+r.getId();
		else
			return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/register/user", method = RequestMethod.GET)
	public String getUserRegisterForm(Model model) {
		List<Location> location_list = DaoPool.getLocationDao().getAll();
		model.addAttribute("location_list", location_list);
		return "form_account_add_user";
	}
	
	@RequestMapping(value = "/register/user", method = RequestMethod.POST)
	public String userRegister(
			Model model,
			String name,
			Integer age,
			String gender,
			Integer locationid,
			String address,
			String email,
			String password
			) {
		UserInfo ui = new UserInfo();
		ui.setName(name);
		ui.setAge(age);
		ui.setGender(gender);
		ui.setLocationId(locationid);
		ui.setAddress(address);
		
		AccountInfo ai = new AccountInfo();
		ai.setAccountName(email);
		ai.setPassword(password);
		ai.setIsLoggedIn(0);
		ai.setStatus("active");
		DaoPool.getAccountInfoDao().persist(ai);
		
		ui.setAccountId(ai.getId());
		DaoPool.getUserInfoDao().persist(ui);
		
		model.addAttribute("user", ui);
		model.addAttribute("account", ai);
		
		return "view_success_register";
	}
	
	@RequestMapping(value = "/register/restaurant", method = RequestMethod.GET)
	public String getRestaurantRegisterForm(Model model) {
		List<Location> location_list = DaoPool.getLocationDao().getAll();
		model.addAttribute("location_list", location_list);
		return "form_account_add_restaurant";
	}
	
	@RequestMapping(value = "/register/restaurant", method = RequestMethod.POST)
	public String restaurantRegister(
			Model model,
			String name,
			Integer locationid,
			String address,
			String email,
			String password
			) {
		Restaurant r = new Restaurant();
		r.setName(name);
		r.setLocationId(locationid);
		r.setAddress(address);
		
		AccountInfo ai = new AccountInfo();
		ai.setAccountName(email);
		ai.setPassword(password);
		ai.setIsLoggedIn(0);
		ai.setStatus("active");
		DaoPool.getAccountInfoDao().persist(ai);
		
		r.setAccountId(ai.getId());
		DaoPool.getRestaurantDao().persist(r);
		
		model.addAttribute("restaurant", r);
		model.addAttribute("account", ai);
		
		return "view_success_register";
	}
}
