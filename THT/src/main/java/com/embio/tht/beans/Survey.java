package com.embio.tht.beans;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1



/**
 * Survey generated by hbm2java
 */
public class Survey implements java.io.Serializable {

	private Integer id;
	private Integer customerId;
	private Integer budgetMin;
	private Integer budgetMax;
	private String trent;

	public Survey() {
	}

	public Survey(int id) {
		this.id = id;
	}

	public Survey(int id, Integer customerId, Integer budgetMin,
			int budgetMax, String trent) {
		this.id = id;
		this.customerId = customerId;
		this.budgetMin = budgetMin;
		this.budgetMax = budgetMax;
		this.trent = trent;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Integer getBudgetMin() {
		return this.budgetMin;
	}

	public void setBudgetMin(int budgetMin) {
		this.budgetMin = budgetMin;
	}

	public Integer getBudgetMax() {
		return this.budgetMax;
	}

	public void setBudgetMax(int budgetMax) {
		this.budgetMax = budgetMax;
	}

	public String getTrent() {
		return this.trent;
	}

	public void setTrent(String trent) {
		this.trent = trent;
	}

}
