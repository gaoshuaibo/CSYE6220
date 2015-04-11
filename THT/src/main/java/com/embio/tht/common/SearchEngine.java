package com.embio.tht.common;

import java.util.ArrayList;
import java.util.List;

import com.embio.tht.beans.*;

public final class SearchEngine {

	public final static List<Dish> searchDish(String keyword){
		DishHome ddao = new DishHome();
		List<Dish> dishes = ddao.getAll();
		List<Dish> filter = new ArrayList<Dish>();
		for(Dish dish:dishes){
			if(dish.getName().contains(keyword)){
				filter.add(ModelFactory.getDish(dish.getId()));
			}
		}
		return filter;
	}
}
