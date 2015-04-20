package com.embio.tht.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TraceModel {
	
	List<TrackUnitModel> items = new ArrayList<TrackUnitModel>();
	public List<TrackUnitModel> getItems() {
		return items;
	}
	public void setTrace(List<TrackUnitModel> items) {
		this.items = items;
	}
	
	public TrackUnitModel findDate(Date date){
		for(TrackUnitModel item:items){
			if(item.isSameDate(date))
				return item;
		}
		return null;
	}
	
	public TrackUnitModel add(Date date, Integer calorie){
		TrackUnitModel unit = findDate(date);
		if(unit == null){
			unit = new TrackUnitModel(date, calorie);
			addByDate(unit);
		}else{
			unit.addCalorie(calorie);			
		}
		return unit;
	}
	
	private void addByDate(TrackUnitModel model){
		int index = 0;
		if(items.size() != 0){
			for(;index<items.size();index++){
				if(items.get(index).getDate().after(model.getDate()))
					break;
			}
		}
		items.add(index, model);
	}
}
