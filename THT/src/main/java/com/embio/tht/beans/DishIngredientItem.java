package com.embio.tht.beans;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * DishIngredientItem generated by hbm2java
 */
public class DishIngredientItem implements java.io.Serializable {

	private Integer id;
	private Integer ingredientId;
	private Integer amount;
	private Integer dishId;

	private Ingredient ingredient;
	public Ingredient getIngredient(){return this.ingredient;}
	public void setIngredient(Ingredient ingredient){this.ingredient = ingredient;}
	
	public DishIngredientItem() {
	}

	public DishIngredientItem(int id, Integer ingredientId, Integer amount, Integer dishId) {
		this.id = id;
		this.ingredientId = ingredientId;
		this.amount = amount;
		this.dishId = dishId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Integer getDishId() {
		return this.dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

}
