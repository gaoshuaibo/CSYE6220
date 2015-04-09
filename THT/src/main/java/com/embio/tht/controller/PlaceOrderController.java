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
@RequestMapping(value = "/placeorder")
public class PlaceOrderController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/place_order", method = RequestMethod.POST)
	public String place(Locale locale, Model model) {

		return "place_order";
	}
}
