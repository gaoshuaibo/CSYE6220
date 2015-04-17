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
		List<Dish> temps = DaoPool.getDishDao().findByExample(search);
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
		
		Dish dish = DaoPool.getDishDao().findById(_dishid);
		DaoPool.getDishDao().delete(dish);

		return "redirect:/dish/view/restaurant?restaurantid="+r.getId();
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String getAddDishForm(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );

		return "form_dish_add_step1";
	}
	
	@RequestMapping(value="/add/step1", method = RequestMethod.POST)
	public String addDishStep1(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			String name,
			Double price,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );
		model.addAttribute("dishname", name);
		model.addAttribute("dishprice", price);
		return "form_dish_add_step2";
	}	
	
	@RequestMapping(value="/add/step2", method = RequestMethod.POST)
	public String addDishStep2(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			String dishname,
			Double dishprice,
			String dishimage,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );
		
		model.addAttribute("dishname", dishname);
		model.addAttribute("dishprice", dishprice);
		model.addAttribute("dishimage", dishimage);
		
		List<Ingredient> ingredients= DaoPool.getIngredientDao().getAll();
		
		model.addAttribute("ingredients", ingredients);
		
		return "form_dish_add_step3";
	}
	
	@RequestMapping(value="/add/step3", method = RequestMethod.POST)
	public String addDishStep3(
			@RequestParam(value="restaurantid") Integer _restaurantid,
			String dishname,
			Double dishprice,
			String dishimage,
			String ingredient_selected,
			String amount,
			Model model) {
		Restaurant r = Checker.isRestaurantLoggedIn(_restaurantid);
		assert(r!=null);
		model.addAttribute("restaurant", r );

		Dish dish = new Dish();
		dish.setName(dishname);
		dish.setPrice(dishprice);
		dish.setRestaurantId(_restaurantid);
		dish.setImage(dishimage);
		DaoPool.getDishDao().persist(dish);
		
		String [] ingredient_tmp = ingredient_selected.split(",");
		String [] amount_tmp = amount.split(",");
		ArrayList<String> amount_tmp_notempty = new ArrayList<String>();
		for(String unit : amount_tmp){
			if(!unit.isEmpty())amount_tmp_notempty.add(unit);
		}
		
		for(int index=0;index<ingredient_tmp.length;index++){
			DishIngredientItem dii = new DishIngredientItem();
			dii.setDishId(dish.getId());
			dii.setIngredientId(Integer.parseInt(ingredient_tmp[index]));
			dii.setAmount(Integer.parseInt(amount_tmp_notempty.get(index)));
			DaoPool.getDishIngredientItemDao().persist(dii);
		}
		

		return "redirect:/dish/view/restaurant?restaurantid="+r.getId();
	}
}
