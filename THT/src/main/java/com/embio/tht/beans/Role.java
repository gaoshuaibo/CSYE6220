package com.embio.tht.beans;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private Integer id;
	private String name;

	public Role() {
	}

	public Role(int id) {
		this.id = id;
	}

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
