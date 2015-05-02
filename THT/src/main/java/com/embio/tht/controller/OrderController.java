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
import com.embio.tht.common.DaoPool;
import com.embio.tht.common.ModelFactory;
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
			Locale locale, 
			Model model) {
		Customer customer = ModelFactory.getCurrentCustomer();
		model.addAttribute("user",customer);

		OrderInfo search = new OrderInfo();
		search.setCustomerId(customer.getId());
		List<OrderInfo> orders = DaoPool.getOrderInfoDao().findByExample(search);
		
		for(OrderInfo order:orders){
			OrderItem search1 = new OrderItem();
			search1.setOrderInfoId(order.getId());
			List<OrderItem> orderItems = DaoPool.getOrderItemDao().findByExample(search1);
			for(OrderItem item:orderItems){
				Dish dish = ModelFactory.getDish(item.getDishId());
				item.setDish(dish);
				order.getItems().add(item);
				
				Ticket search2 = new Ticket();
				search2.setOrderItemId(item.getId());
				Ticket t = DaoPool.getTicketDao().findFirstByExample(search2);
				item.setTicket(t);
			}
		}

		int total_calorie = 0;
		for(OrderInfo order:orders){
			total_calorie += order.getComsumedCalorie() + order.getUncomsumedCalorie();
		}
		
		model.addAttribute("orders", orders);
		model.addAttribute("total_calorie", total_calorie);
		
		return "view_user_order";
	}
	
	@RequestMapping(value = "/view/restaurant", method = RequestMethod.GET)
	public String order(
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		OrderItem search = new OrderItem();
		search.setRestaurantId(restaurant.getId());
		List<OrderItem> orderItems = DaoPool.getOrderItemDao().findByExample(search);
		for(OrderItem item:orderItems){
			item.setDish(ModelFactory.getDish(item.getDishId()));
		}

		model.addAttribute("orderItems", orderItems);
		
		return "view_restaurant_order";
	}
	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public String place(
			Model model) {
		Customer customer = ModelFactory.getCurrentCustomer();
		model.addAttribute("user",customer);
		
		OrderInfo oinfo = new OrderInfo();
		oinfo.setCustomerId(customer.getId());
		oinfo.setTimeStamp((new Date()).toString());
		DaoPool.getOrderInfoDao().persist(oinfo);
		
		CartItemUnit ciu = new CartItemUnit();
		ciu.setUserInfoId(customer.getId());
		ciu.setPlaced(0);
		List<CartItemUnit> items = DaoPool.getCartItemUnitDao().findByExample(ciu);
		
		for(CartItemUnit item:items){
			OrderItem oitem = new OrderItem();
			oitem.setDishId(item.getDishId());
			oitem.setOrderInfoId(oinfo.getId());
			oitem.setQuantity(item.getQuantity());
			oitem.setRestaurantId(item.getRestaurantId());
			oitem.setUsed(0);
			DaoPool.getOrderItemDao().persist(oitem);
			
			//set the dish object
			Dish dish = DaoPool.getDishDao().findById(item.getDishId());
			oitem.setDish(dish);
			
			//finance start
			
			FinanceItem fi = new FinanceItem();
			fi.setIncome(oitem.getBalance());
			fi.setOutcome(0.0);
			fi.setOrderId(oinfo.getId());
			DaoPool.getFinanceItemDao().persist(fi);
			
			//finance end
			
			Ticket ticket = new Ticket();
			ticket.setOrderItemId(oitem.getId());
			ticket.setCode(TicketGenerater.generateCode());
			DaoPool.getTicketDao().persist(ticket);
			
			item.setPlaced(1);
			DaoPool.getCartItemUnitDao().attachDirty(item);
		}

		return "redirect:/order/view/user";
	}
	
	@RequestMapping(value = "/consume", method = RequestMethod.POST)
	public String consume(
			@RequestParam(value="itemid") Integer _itemid,
			String code,
			Model model) {
		Ticket search = new Ticket();
		search.setOrderItemId(_itemid);
		Ticket t = DaoPool.getTicketDao().findFirstByExample(search);
		if(!t.getCode().equals(code)){
			//TODO send error
			return "error";
		}
		
		OrderItem oi = DaoPool.getOrderItemDao().findById(_itemid);
		oi.setUsed(1);
		oi.setConsumeTime((new Date()).toString());
		DaoPool.getOrderItemDao().attachDirty(oi);	
		
		//set the dish object
		Dish dish = DaoPool.getDishDao().findById(oi.getDishId());
		oi.setDish(dish);
		
		
		//finance start
		
		FinanceItem fi = new FinanceItem();
		fi.setIncome(0.0);
		fi.setOutcome(oi.getBalance()*0.8);
		fi.setOrderId(oi.getOrderInfoId());
		DaoPool.getFinanceItemDao().persist(fi);
		
		//finance end
		
		return "redirect:/order/view/restaurant";
	}
}
