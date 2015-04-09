package com.embio.tht.common;

import com.embio.tht.beans.AccountInfo;
import com.embio.tht.beans.AccountInfoHome;
import com.embio.tht.beans.UserInfo;
import com.embio.tht.beans.UserInfoHome;

public final class Checker {

	public static UserInfo isUserLoggedIn(Integer userid){
		UserInfoHome uidao = new UserInfoHome();
		UserInfo ui = uidao.findById(userid);
		if(ui != null)
		{
			AccountInfoHome aidao = new AccountInfoHome();
			AccountInfo ai = aidao.findById(ui.getAccountId());
			if(ai != null)
				return (ai.getIsLoggedIn() == 1)?ui:null;
		}
		return null;
	}
}
