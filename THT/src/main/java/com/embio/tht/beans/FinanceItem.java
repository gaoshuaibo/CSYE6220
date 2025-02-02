package com.embio.tht.beans;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * FinanceItem generated by hbm2java
 */
public class FinanceItem implements java.io.Serializable {

	private Integer id;
	private Double income;
	private Double outcome;
	private Integer orderId;

	public FinanceItem() {
	}

	public FinanceItem(int id, Integer orderId) {
		this.id = id;
		this.orderId = orderId;
	}

	public FinanceItem(int id, Double income, Double outcome, Integer orderId) {
		this.id = id;
		this.income = income;
		this.outcome = outcome;
		this.orderId = orderId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getOutcome() {
		return this.outcome;
	}

	public void setOutcome(Double outcome) {
		this.outcome = outcome;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
