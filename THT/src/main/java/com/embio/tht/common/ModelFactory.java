package com.embio.tht.common;

import java.util.List;

import com.embio.tht.beans.*;

public final class ModelFactory {

	public static Dish getDish(int dishid){
		DishHome ddao = new DishHome();
		Dish dish = ddao.findById(dishid);

		dish.setRestaurant(getRestaurant(dish.getRestaurantId()));
		
		dish.setIngredients(getDishIngredient(dishid));

		return dish;
	}
	
	public static Restaurant getRestaurant(int restaurantid){
		RestaurantHome rdao = new RestaurantHome();
		Restaurant restaurant = rdao.findById(restaurantid);
		restaurant.setLocation(getLocation(restaurant.getLocationId()));
		return restaurant;
	}
	
	public static Location getLocation(int locationid){
		LocationHome ldao = new LocationHome();
		return ldao.findById(locationid);
	}
	
	public static Ingredient getIngredient(int ingredientid){
		IngredientHome idao = new IngredientHome();
		return idao.findById(ingredientid);
	}
	
	public static List<DishIngredientItem> getDishIngredient(int dishid){
		DishIngredientItemHome diidao = new DishIngredientItemHome();
		DishIngredientItem search = new DishIngredientItem();
		search.setDishId(dishid);
		List<DishIngredientItem> items = diidao.findByExample(search);
		for(DishIngredientItem item:items){
			item.setIngredient(getIngredient(item.getIngredientId()));
		}
		return items;
	}

	public static CartItemUnit getCartItemUnit(int itemid){
		CartItemUnitHome ciudao = new CartItemUnitHome();
		CartItemUnit ciu = ciudao.findById(itemid);
		ciu.setDish(getDish(ciu.getDishId()));
		ciu.setRestaurant(getRestaurant(ciu.getRestaurantId()));
		ciu.setUserInfo(ModelFactory.getUser(ciu.getUserInfoId()));
		return ciu;
	}
	
	public static UserInfo getUser(int userid){
		UserInfoHome uidao = new UserInfoHome();
		return uidao.findById(userid);
	}
}
