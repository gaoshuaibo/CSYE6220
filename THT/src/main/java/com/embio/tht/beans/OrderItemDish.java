package com.embio.tht.beans;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * OrderItemDish generated by hbm2java
 */
public class OrderItemDish implements java.io.Serializable {

	private Integer id;
	private Integer orderItemId;
	private Integer dishId;

	public OrderItemDish() {
	}

	public OrderItemDish(int id, Integer orderItemId, Integer dishId) {
		this.id = id;
		this.orderItemId = orderItemId;
		this.dishId = dishId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getDishId() {
		return this.dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

}
