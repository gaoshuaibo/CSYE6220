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
@RequestMapping(value = "/")
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		
//		DishHome dishDao = new DishHome();
//		Dish search = new Dish();
//		search.setRestaurantId(1);
//		List<Dish> dishes = dishDao.findByExample(search);
//
//		model.addAttribute("dishes", dishes );

		return "redirect:home";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeLoggedIn(
			@RequestParam(value="userid", required=false) String _userid,
			Locale locale,
			Model model) {
		
		if(_userid != null){
			int userid = Integer.parseInt(_userid);
			UserInfo ui = Checker.isUserLoggedIn(userid);
			if(ui!=null)
				model.addAttribute("user", ui );
		}
		
		DishHome dishDao = new DishHome();
		Dish search = new Dish();
		search.setRestaurantId(1);
		List<Dish> dishes = dishDao.findByExample(search);
		
		model.addAttribute("dishes", dishes );

		
		return "home";
	}
	
//	@RequestMapping(value = "home", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		DishHome dishDao = new DishHome();
//		Dish search = new Dish();
//		search.setRestaurantId(1);
//		List<Dish> dishes = dishDao.findByExample(search);
//		
//		model.addAttribute("dishes", dishes );
//		
//		return "home";
//	}
}
