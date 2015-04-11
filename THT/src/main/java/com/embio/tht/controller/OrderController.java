package com.embio.tht.controller;

import java.util.Date;
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
import com.embio.tht.common.TicketGenerater;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "view/user", method = RequestMethod.GET)
	public String order(
			@RequestParam(value="userid") Integer _userid,
			Locale locale, 
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		model.addAttribute("user", ui);

		OrderInfo search = new OrderInfo();
		search.setCustomerId(ui.getId());
		OrderInfoHome oinfodao = new OrderInfoHome();
		List<OrderInfo> orders = oinfodao.findByExample(search);
		
		for(OrderInfo order:orders){
			OrderItem search1 = new OrderItem();
			search1.setOrderInfoId(order.getId());
			OrderItemHome oitemdao = new OrderItemHome();
			List<OrderItem> orderItems = oitemdao.findByExample(search1);
			for(OrderItem item:orderItems){
				DishHome ddao = new DishHome();
				Dish dish = ddao.findById(item.getDishId());
				item.setDish(dish);
				order.getItems().add(item);
				
				Ticket search2 = new Ticket();
				search2.setOrderItemId(item.getId());
				TicketHome tdao = new TicketHome();
				Ticket t = tdao.findFirstByExample(search2);
				item.setTicket(t);
			}
		}

		model.addAttribute("orders", orders);
		
		return "view_user_order";
	}
	
	@RequestMapping(value = "/view/restaurant", method = RequestMethod.GET)
	public String order(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		if(r == null) return "redirect:/account/login/restaurant";
		model.addAttribute("restaurant", r);
		
		OrderItem search = new OrderItem();
		search.setRestaurantId(r.getId());
		OrderItemHome oitemdao = new OrderItemHome();
		List<OrderItem> orderItems = oitemdao.findByExample(search);
		for(OrderItem item:orderItems){
			DishHome ddao = new DishHome();
			Dish dish = ddao.findById(item.getDishId());
			item.setDish(dish);
		}

		model.addAttribute("orderItems", orderItems);
		
		return "view_restaurant_order";
	}
	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public String place(
			@RequestParam(value="userid") Integer _userid,
			Model model) {
		UserInfo ui = Checker.isUserLoggedIn(_userid);
		if(ui == null) return "redirect:/account/login/user";
		
		OrderInfo oinfo = new OrderInfo();
		oinfo.setCustomerId(ui.getId());
		oinfo.setTimeStamp((new Date()).toString());
		OrderInfoHome oinfodao = new OrderInfoHome();
		oinfodao.persist(oinfo);
		
		CartItemUnit ciu = new CartItemUnit();
		ciu.setUserInfoId(ui.getId());
		ciu.setPlaced(0);
		CartItemUnitHome ciudao = new CartItemUnitHome();
		List<CartItemUnit> items = ciudao.findByExample(ciu);
		
		for(CartItemUnit item:items){
			OrderItem oitem = new OrderItem();
			oitem.setDishId(item.getDishId());
			oitem.setOrderInfoId(oinfo.getId());
			oitem.setQuantity(item.getQuantity());
			oitem.setRestaurantId(item.getRestaurantId());
			OrderItemHome oitemdao = new OrderItemHome();
			oitemdao.persist(oitem);
			
			Ticket ticket = new Ticket();
			ticket.setOrderItemId(oitem.getId());
			ticket.setCode(TicketGenerater.generateCode());
			TicketHome tdao = new TicketHome();
			tdao.persist(ticket);
			
			item.setPlaced(1);
			ciudao.attachDirty(item);
		}

		return "redirect:/order/view/user?userid="+ui.getId();
	}
	
	@RequestMapping(value = "/consume", method = RequestMethod.POST)
	public String consume(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			@RequestParam(value="itemid") Integer _itemid,
			String code,
			Model model) {
		Ticket search = new Ticket();
		search.setOrderItemId(_itemid);
		TicketHome tdao = new TicketHome();
		Ticket t = tdao.findFirstByExample(search);
		if(!t.getCode().equals(code)){
			//TODO send error
			return "error";
		}
		
		OrderItemHome oitemdao = new OrderItemHome();
		OrderItem oi = oitemdao.findById(_itemid);
		oi.setConsumeTime((new Date()).toString());
		oitemdao.attachDirty(oi);		
		
		return "redirect:/order/view/restaurant?restaurantid=" + _restaurantid;
	}
}
