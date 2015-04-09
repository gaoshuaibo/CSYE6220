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
@RequestMapping(value = "/user")
public class UserController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getView(
			@RequestParam(value="userid", required=false) String _userid,
			Model model) {
		if(_userid == null){
			return "login";
		}
		
		int userid = Integer.parseInt(_userid);
		UserInfo ui = Checker.isUserLoggedIn(userid);
		
		if(ui == null) return "login";

		model.addAttribute("user",ui);
		
		return "user";
	}
}
