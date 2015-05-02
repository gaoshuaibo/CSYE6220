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
import com.embio.tht.common.DaoPool;
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/finance")
public class FinanceController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getView(
			Model model) {
		
		List<FinanceItem> fis = DaoPool.getFinanceItemDao().getAll();
		
		double balance = 0.0;
		for(FinanceItem fi:fis){
			balance += fi.getIncome();
			balance -= fi.getOutcome();
		}
		model.addAttribute("balance",balance);
		model.addAttribute("items",fis);
		
		return "view_finance_report";
	}
}
