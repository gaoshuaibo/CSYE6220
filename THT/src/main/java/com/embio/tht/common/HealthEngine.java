package com.embio.tht.common;

import java.util.ArrayList;
import java.util.List;

import com.embio.tht.beans.*;

public final class HealthEngine {

	public static HealthReportModel AnalysisUser(UserInfo ui){
		List<OrderInfo> orders = ModelFactory.getOrderInfosByUser(ui.getId());
		
		HealthReportModel healthReportModel = new HealthReportModel();
		healthReportModel.setTodayConsumedCalorie(getTodayConsumedCalorie(orders));
		healthReportModel.setTotalConsumedCalorie(getTotalConsumedCalorie(orders));
		healthReportModel.setTotalUncomsumedCalorie(getTotalUnconsumedCalorie(orders));
		healthReportModel.setTrace(getTrace(orders));
		
		return healthReportModel;
	}

	private static TraceModel getTrace(List<OrderInfo> orders){
		TraceModel trace = new TraceModel();
		
		for(OrderInfo oi:orders){
			for(OrderItem item:oi.getItems()){
				if(item.isConsume())
				trace.add(item.getConsumeDate(), item.getComsumedCalorie());
			}
		}
		
		return trace;
	}
	
	private static Integer getTotalConsumedCalorie(List<OrderInfo> orders){
		int calorie = 0;
		for(OrderInfo oi:orders){
			calorie += oi.getComsumedCalorie();
		}
		return calorie;
	}
	
	private static Integer getTotalUnconsumedCalorie(List<OrderInfo> orders){
		int calorie = 0;
		for(OrderInfo oi:orders){
			calorie += oi.getUncomsumedCalorie();
		}
		return calorie;
	}
	
	private static Integer getTodayConsumedCalorie(List<OrderInfo> orders){
		int calorie = 0;
		for(OrderInfo oi:orders){
			calorie += oi.getTodayComsumedCalorie();
		}
		return calorie;
	}
}
