package com.embio.tht.common;

import com.embio.tht.beans.*;

public final class Checker {

	public static UserInfo isUserLoggedIn(Integer userid){
		UserInfo ui = ModelFactory.getUser(userid);
		if(ui != null)
		{
			AccountInfo ai = DaoPool.getAccountInfoDao().findById(ui.getAccountId());
			if(ai != null)
				return (ai.getIsLoggedIn() == 1)?ui:null;
		}
		return null;
	}
	
	public static Restaurant isRestaurantLoggedIn(Integer restaurantid){
		Restaurant r = ModelFactory.getRestaurant(restaurantid);
		if(r != null)
		{
			AccountInfo ai = DaoPool.getAccountInfoDao().findById(r.getAccountId());
			if(ai != null)
				return (ai.getIsLoggedIn() == 1)?r:null;
		}
		return null;
	}
}
