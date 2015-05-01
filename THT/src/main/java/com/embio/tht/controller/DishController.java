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
	@RequestMapping(value="/viewdetails", method = RequestMethod.GET)
	public String userViewDish(
			@RequestParam(value="dishid") Integer _dishid,
			Model model) {
		Customer customer = ModelFactory.getCurrentCustomer();
		model.addAttribute("customer",customer);
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		Dish dish = ModelFactory.getDish(_dishid);
		model.addAttribute("dish", dish);
		
		Survey search = new Survey();
		search.setCustomerId(dish.getId());
		List<Survey> reviews = DaoPool.getSurveyDao().findByExample(search);
		model.addAttribute("reviews", reviews);
		
		return "view_dish";
	}
	
	@RequestMapping(value="/view/restaurant", method = RequestMethod.GET)
	public String viewRestaurantMenu(
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		Dish search = new Dish();
		search.setRestaurantId(restaurant.getId());
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
			@RequestParam(value="dishid") Integer _dishid,
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		Dish dish = DaoPool.getDishDao().findById(_dishid);
		DaoPool.getDishDao().delete(dish);

		return "redirect:/dish/view/restaurant";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String getAddDishForm(
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);

		return "form_dish_add_step1";
	}
	
	@RequestMapping(value="/add/step1", method = RequestMethod.POST)
	public String addDishStep1(
			String name,
			Double price,
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		model.addAttribute("dishname", name);
		model.addAttribute("dishprice", price);
		return "form_dish_add_step2";
	}	
	
	@RequestMapping(value="/add/step2", method = RequestMethod.POST)
	public String addDishStep2(
			String dishname,
			Double dishprice,
			String dishimage,
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);
		
		model.addAttribute("dishname", dishname);
		model.addAttribute("dishprice", dishprice);
		model.addAttribute("dishimage", dishimage);
		
		List<Ingredient> ingredients= DaoPool.getIngredientDao().getAll();
		
		model.addAttribute("ingredients", ingredients);
		
		return "form_dish_add_step3";
	}
	
	@RequestMapping(value="/add/step3", method = RequestMethod.POST)
	public String addDishStep3(
			String dishname,
			Double dishprice,
			String dishimage,
			String ingredient_selected,
			String amount,
			Model model) {
		Restaurant restaurant = ModelFactory.getCurrentRestaurant();
		model.addAttribute("restaurant",restaurant);

		Dish dish = new Dish();
		dish.setName(dishname);
		dish.setPrice(dishprice);
		dish.setRestaurantId(restaurant.getId());
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
		

		return "redirect:/dish/view/restaurant";
	}

	@RequestMapping(value="/review/add", method = RequestMethod.POST)
	public String addreview(
			@RequestParam(value="dishid") Integer _dishid,
			String review_text,
			Model model) {

		Survey survey = new Survey();
		survey.setCustomerId(_dishid);
		survey.setTrent(review_text);
		survey.setBudgetMax(0);
		survey.setBudgetMin(0);
		
		DaoPool.getSurveyDao().persist(survey);

		return "redirect:/dish/viewdetails?dishid=" + _dishid;
	}
}
