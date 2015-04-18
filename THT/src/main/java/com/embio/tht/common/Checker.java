package com.embio.tht.common;

import com.embio.tht.beans.*;

public final class Checker {

	public static Customer isUserLoggedIn(Integer userid){
		Customer ui = ModelFactory.getCustomer(userid);
		if(ui != null)
		{
			Users ai = DaoPool.getUsersDao().findById(ui.getAccountId());
			if(ai != null)
				return (ai.getIsLoggedIn() == 1)?ui:null;
		}
		return null;
	}
	
	public static Restaurant isRestaurantLoggedIn(Integer restaurantid){
		Restaurant r = ModelFactory.getRestaurant(restaurantid);
		if(r != null)
		{
			Users ai = DaoPool.getUsersDao().findById(r.getAccountId());
			if(ai != null)
				return (ai.getIsLoggedIn() == 1)?r:null;
		}
		return null;
	}
}
