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
import com.embio.tht.common.FileUploader;
import com.embio.tht.common.ModelFactory;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/dish")
public class DishController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/view/user", method = RequestMethod.GET)
	public String userViewDish(
			@RequestParam(value="userid", required=false) String _userid,
			@RequestParam(value="dishid") Integer _dishid,
			Model model) {
		if(_userid != null){
			int userid = Integer.parseInt(_userid);
			UserInfo ui = Checker.isUserLoggedIn(userid);
			model.addAttribute("user", ui );
		}
//
//		DishHome ddao = new DishHome();
//		Dish dish = ddao.findById(_dishid);
//		model.addAttribute("dish", dish );
//		
//		RestaurantHome rdao = new RestaurantHome();
//		Restaurant restaurant = rdao.findById(dish.getRestaurantId());
//		model.addAttribute("restaurant", restaurant );
//		
//		LocationHome ldao = new LocationHome();
//		Location location = ldao.findById(restaurant.getLocationId());
//		model.addAttribute("location", location );
//		
//		DishIngredientItem search = new DishIngredientItem();
//		search.setDishId(_dishid);
//		DishIngredientItemHome diidao = new DishIngredientItemHome();
//		List<DishIngredientItem> dishIngredients = diidao.findByExample(search);
//		
//		IngredientHome idao = new IngredientHome();
//		for(DishIngredientItem dii:dishIngredients){
//			Ingredient ingredient = idao.findById(dii.getIngredientId());
//			dii.setIngredient(ingredient);
//		}
//		
//		model.addAttribute("dishIngredients", dishIngredients );
//		
//		dish.setIngredients(dishIngredients);
		Dish dish = ModelFactory.getDish(_dishid);
		model.addAttribute("dish", dish);
		
		return "view_user_dish";
	}
	
	@RequestMapping(value="/view/restaurant", method = RequestMethod.GET)
	public String viewRestaurantMenu(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		model.addAttribute("restaurant", r );
		
		Dish search = new Dish();
		search.setRestaurantId(_restaurantid);
		DishHome ddao = new DishHome();
		List<Dish> temps = ddao.findByExample(search);
		List<Dish> dishes = new ArrayList<Dish>();
		for(Dish temp:temps){
			dishes.add(ModelFactory.getDish(temp.getId()));
		}

		model.addAttribute("dishes", dishes );

		return "view_restaurant_menu";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String removeDish(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			@RequestParam(value="dishid") Integer _dishid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );
		
		DishHome ddao = new DishHome();
		Dish dish = ddao.findById(_dishid);
		ddao.delete(dish);

		return "redirect:/dish/view/restaurant?restaurantid="+r.getId();
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String getAddDishForm(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );

		return "form_dish_add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addDish(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			String name,
			Double price,
			String image,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		
		Dish dish = new Dish();
		dish.setName(name);
		dish.setPrice(price);
		dish.setRestaurantId(_restaurantid);
		dish.setImage(image);
		
		DishHome ddao = new DishHome();
		ddao.persist(dish);

		return "redirect:/dish/view/restaurant?restaurantid="+r.getId();
	}
}
