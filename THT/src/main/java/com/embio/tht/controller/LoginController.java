package com.embio.tht.controller;

import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.embio.tht.beans.*;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm(Model model) {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(Locale locale, Model model, String username,String password, HttpSession session) {
		
		AccountInfo search = new AccountInfo();
		search.setAccountName(username);
		search.setPassword(password);
		AccountInfoHome aidao = new AccountInfoHome();
		AccountInfo ai = aidao.findFirstByExample(search);
		if(ai == null)
		{
			return "login";
		}
		ai.setIsLoggedIn(1);
		aidao.attachDirty(ai);
		
		UserInfoHome uidao = new UserInfoHome();
		UserInfo search1 = new UserInfo();
		search1.setAccountId(ai.getId());
		UserInfo ui = uidao.findFirstByExample(search1);
		model.addAttribute("user", ui);
		
		return "redirect:/home?userid="+ui.getId();
	}
}
