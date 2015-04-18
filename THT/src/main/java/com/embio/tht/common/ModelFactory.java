package com.embio.tht.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.embio.tht.beans.CartItemUnit;
import com.embio.tht.beans.Customer;
import com.embio.tht.beans.Dish;
import com.embio.tht.beans.DishIngredientItem;
import com.embio.tht.beans.Ingredient;
import com.embio.tht.beans.Location;
import com.embio.tht.beans.OrderInfo;
import com.embio.tht.beans.OrderItem;
import com.embio.tht.beans.Restaurant;
import com.embio.tht.beans.Users;

public final class ModelFactory {

	public static String getCurrentRole(){
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
			return "ANONYMOUS";
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for( GrantedAuthority ga: userDetails.getAuthorities()){ 
			return ga.getAuthority();
		}
		return "ANONYMOUS";
	}
	
	public static Customer getCurrentCustomer(){
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
			return null;
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Users search = new Users();
		search.setUserName(userDetails.getUsername());
		Users user = DaoPool.getUsersDao().findFirstByExample(search);
		Customer search1 = new Customer();
		search1.setAccountId(user.getId());
		Customer customer = DaoPool.getCustomerDao().findFirstByExample(search1);
		Customer customer_filled = getCustomer(customer.getId());
		return customer_filled;
	}
	
	public static Restaurant getCurrentRestaurant(){
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
			return null;
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Users search = new Users();
		search.setUserName(userDetails.getUsername());
		Users user = DaoPool.getUsersDao().findFirstByExample(search);
		Restaurant search1 = new Restaurant();
		search1.setAccountId(user.getId());
		Restaurant restaurant = DaoPool.getRestaurantDao().findFirstByExample(search1);
		Restaurant restaurant_filled = getRestaurant(restaurant.getId());
		return restaurant_filled;
	}
	
	public static Dish getDish(int dishid){
		Dish dish = DaoPool.getDishDao().findById(dishid);

		dish.setRestaurant(getRestaurant(dish.getRestaurantId()));
		
		dish.setIngredients(getDishIngredient(dishid));

		return dish;
	}
	
	public static Restaurant getRestaurant(int restaurantid){
		Restaurant restaurant = DaoPool.getRestaurantDao().findById(restaurantid);
		restaurant.setLocation(getLocation(restaurant.getLocationId()));
		return restaurant;
	}
	
	public static Location getLocation(int locationid){
		return DaoPool.getLocationDao().findById(locationid);
	}
	
	public static Ingredient getIngredient(int ingredientid){
		return DaoPool.getIngredientDao().findById(ingredientid);
	}
	
	public static List<DishIngredientItem> getDishIngredient(int dishid){
		DishIngredientItem search = new DishIngredientItem();
		search.setDishId(dishid);
		List<DishIngredientItem> items = DaoPool.getDishIngredientItemDao().findByExample(search);
		for(DishIngredientItem item:items){
			item.setIngredient(getIngredient(item.getIngredientId()));
		}
		return items;
	}

	public static List<CartItemUnit> getCartItemUnitsByUser(int userid){
		CartItemUnit search = new CartItemUnit();
		search.setUserInfoId(userid);
		List<CartItemUnit> tmp = DaoPool.getCartItemUnitDao().findByExample(search);
		List<CartItemUnit> items = new ArrayList<CartItemUnit>();
		for(CartItemUnit ciu: tmp){
			items.add(getCartItemUnit(ciu.getId()));
		}
		return items;
	}
	
	public static CartItemUnit getCartItemUnit(int itemid){
		CartItemUnit ciu = DaoPool.getCartItemUnitDao().findById(itemid);
		ciu.setDish(getDish(ciu.getDishId()));
		ciu.setRestaurant(getRestaurant(ciu.getRestaurantId()));
		ciu.setCustomer(ModelFactory.getCustomer(ciu.getUserInfoId()));
		return ciu;
	}
	
	public static Customer getCustomer(int userid){
		Customer user = DaoPool.getCustomerDao().findById(userid);
		user.setLocation(getLocation(user.getLocationId()));
		return user;
	}
	
	public static List<OrderInfo> getOrderInfosByUser(int userid){
		OrderInfo search = new OrderInfo();
		search.setCustomerId(userid);
		
		List<OrderInfo> tmp = DaoPool.getOrderInfoDao().findByExample(search);
		List<OrderInfo> items = new ArrayList<OrderInfo>();
		for(OrderInfo oi: tmp){
			items.add(getOrderInfo(oi.getId()));
		}
		return items;
	}
	
	public static OrderInfo getOrderInfo(int orderid){
		OrderInfo oi = DaoPool.getOrderInfoDao().findById(orderid);
		oi.setCustomer(getCustomer(oi.getCustomerId()));
		oi.setItems(getOrderItemsByOrderInfo(oi.getId()));
		return oi;
	}
	
	public static List<OrderItem> getOrderItemsByOrderInfo(int orderid){
		OrderItem search = new OrderItem();
		search.setOrderInfoId(orderid);
		List<OrderItem> tmp = DaoPool.getOrderItemDao().findByExample(search);
		List<OrderItem> items = new ArrayList<OrderItem>();
		for(OrderItem oi: tmp){
			items.add(getOrderItem(oi.getId()));
		}
		return items;
	}
	
	public static OrderItem getOrderItem(int itemid){
		OrderItem oi = DaoPool.getOrderItemDao().findById(itemid);
		oi.setDish(getDish(oi.getDishId()));
		oi.setRestaurant(getRestaurant(oi.getRestaurantId()));
		return oi;
	}
}
