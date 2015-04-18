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
import com.embio.tht.common.SearchEngine;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public String Search(
			String keyword,
			Model model) {
		Customer customer = ModelFactory.getCurrentCustomer();
		model.addAttribute("user",customer);
		
		List<Dish> result = SearchEngine.searchDish(keyword);
		model.addAttribute("result",result);
		
		return "view_search";
	}
}
