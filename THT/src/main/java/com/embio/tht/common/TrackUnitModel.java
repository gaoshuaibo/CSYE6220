package com.embio.tht.common;

import java.util.Date;

public class TrackUnitModel {
	
	private Date date;
	private Integer calorie = 0;

	public TrackUnitModel(Date date, Integer calorie){
		this.date = date;
		this.calorie = calorie;
	}
	
	public Date getDate() {
		return date;
	}

	public Integer getCalorie() {
		return calorie;
	}
	
	public void addCalorie(Integer calorie){
		this.calorie += calorie;
	}
	
	public boolean isSameDate(Date date){
		if(this.date.getYear() == date.getYear() &&
			this.date.getMonth() == date.getMonth() &&
			this.date.getDate() == date.getDate())
			return true;
		return false;
	}
	
	public String getDisplayDate(){
		return (this.date.getMonth()+1) + "/" + this.date.getDate() + "/" + (this.date.getYear()+1900);
	}
}
