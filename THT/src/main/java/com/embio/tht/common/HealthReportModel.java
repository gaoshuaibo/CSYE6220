package com.embio.tht.common;

import java.util.ArrayList;
import java.util.List;

public class HealthReportModel {
	
	private Integer totalConsumedCalorie;
	public Integer getTotalConsumedCalorie(){return this.totalConsumedCalorie;}
	public void setTotalConsumedCalorie(Integer value){this.totalConsumedCalorie = value;}
	
	private Integer totalUncomsumedCalorie;
	public Integer getTotalUncomsumedCalorie(){return this.totalUncomsumedCalorie;}
	public void setTotalUncomsumedCalorie(Integer value){this.totalUncomsumedCalorie = value;}
	
	private Integer todayConsumedCalorie;
	public Integer getTodayConsumedCalorie(){return this.todayConsumedCalorie;}
	public void setTodayConsumedCalorie(Integer value){this.todayConsumedCalorie = value;}
	
//	private Integer todayUnconsumedCalorie;
//	public Integer getTodayUnconsumedCalorie(){return this.todayUnconsumedCalorie;}
//	public void setTodayUnconsumedCalorie(Integer value){this.todayUnconsumedCalorie = value;}
	
	//google chart stuff

	private TraceModel trace;
	public TraceModel getTrace() {
		return trace;
	}
	public void setTrace(TraceModel trace) {
		this.trace = trace;
	}
	
	
}
