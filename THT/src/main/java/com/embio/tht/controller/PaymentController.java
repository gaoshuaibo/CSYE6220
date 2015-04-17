package com.embio.tht.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.embio.tht.beans.*;
import com.embio.tht.common.Checker;
import com.embio.tht.common.DaoPool;
import com.embio.tht.common.FileUploader;
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/payment")
public class PaymentController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getPaymentForm(
			int userid,
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(userid);
		if(ui == null) return "redirect:/account/login/user";
		
		model.addAttribute("user", ui);
		
		return "form_payment";
	}
	
	@RequestMapping(value="/commit", method = RequestMethod.POST)
	public String commit(
			@RequestParam(value="userid") int _userid,
			String cardid,
			String expiremonth,
			String expireyear,
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		
		Cards search = new Cards();
		search.setCardId(cardid);
		Cards card = DaoPool.getCardsDao().findFirstByExample(search);
		
		if(card == null) return "card not found";
		
		if(card.getExpireMonth().equals(expiremonth) && card.getExpireYear().equals(expireyear))
		{
			return "redirect:/order/place?userid=" + _userid;
		}
		
		return "card verified failed";
	}
}
