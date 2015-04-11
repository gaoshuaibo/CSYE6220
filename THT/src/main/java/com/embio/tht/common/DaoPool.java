package com.embio.tht.common;

import com.embio.tht.beans.*;

public final class DaoPool {
	private static AccountInfoHome accountInfoDao;
	private static AllergyHome allergyDao;
	private static CalorieHome calorieDao;
	private static CardsHome cardsDao;
	private static CartItemHome cartItemDao;
	private static CartItemUnitHome cartItemUnitDao;
	private static DishHome dishDao;
	private static DishIngredientItemHome dishIngredientItemDao;
	private static EatingHabbitHome eatingHabbitDao;
	private static FinanceItemHome financeItemDao;
	private static IngredientHome ingredientDao;
	private static LocationHome locationDao;
	private static OrderInfoHome orderInfoDao;
	private static OrderItemHome orderItemDao;
	private static OrderItemDishHome orderItemDishDao;
	private static PaymentHome paymentDao;
	private static RestaurantHome restaurantDao;
	private static RoleHome roleDao;
	private static SurveyHome surveyDao;
	private static SystemInfoHome systemInfoDao;
	private static TicketHome ticketDao;
	private static UserInfoHome userInfoDao;
	
	public static AccountInfoHome getAccountInfoHome (){if( accountInfoDao == null)accountInfoDao =new AccountInfoHome ();return accountInfoDao;}
	public static AllergyHome getAllergyHome (){if( allergyDao == null)allergyDao =new AllergyHome ();return allergyDao;}
	public static CalorieHome getCalorieHome (){if( calorieDao == null)calorieDao =new CalorieHome ();return calorieDao;}
	public static CardsHome getCardsHome (){if( cardsDao == null)cardsDao =new CardsHome ();return cardsDao;}
	public static CartItemHome getCartItemHome (){if( cartItemDao == null)cartItemDao =new CartItemHome ();return cartItemDao;}
	public static CartItemUnitHome getCartItemUnitHome (){if( cartItemUnitDao == null)cartItemUnitDao =new CartItemUnitHome ();return cartItemUnitDao;}
	public static DishHome getDishHome (){if( dishDao == null)dishDao =new DishHome ();return dishDao;}
	public static DishIngredientItemHome getDishIngredientItemHome (){if( dishIngredientItemDao == null)dishIngredientItemDao =new DishIngredientItemHome ();return dishIngredientItemDao;}
	public static EatingHabbitHome getEatingHabbitHome (){if( eatingHabbitDao == null)eatingHabbitDao =new EatingHabbitHome ();return eatingHabbitDao;}
	public static FinanceItemHome getFinanceItemHome (){if( financeItemDao == null)financeItemDao =new FinanceItemHome ();return financeItemDao;}
	public static IngredientHome getIngredientHome (){if( ingredientDao == null)ingredientDao =new IngredientHome ();return ingredientDao;}
	public static LocationHome getLocationHome (){if( locationDao == null)locationDao =new LocationHome ();return locationDao;}
	public static OrderInfoHome getOrderInfoHome (){if( orderInfoDao == null)orderInfoDao =new OrderInfoHome ();return orderInfoDao;}
	public static OrderItemHome getOrderItemHome (){if( orderItemDao == null)orderItemDao =new OrderItemHome ();return orderItemDao;}
	public static OrderItemDishHome getOrderItemDishHome (){if( orderItemDishDao == null)orderItemDishDao =new OrderItemDishHome ();return orderItemDishDao;}
	public static PaymentHome getPaymentHome (){if( paymentDao == null)paymentDao =new PaymentHome ();return paymentDao;}
	public static RestaurantHome getRestaurantHome (){if( restaurantDao == null)restaurantDao =new RestaurantHome ();return restaurantDao;}
	public static RoleHome getRoleHome (){if( roleDao == null)roleDao =new RoleHome ();return roleDao;}
	public static SurveyHome getSurveyHome (){if( surveyDao == null)surveyDao =new SurveyHome ();return surveyDao;}
	public static SystemInfoHome getSystemInfoHome (){if( systemInfoDao == null)systemInfoDao =new SystemInfoHome ();return systemInfoDao;}
	public static TicketHome getTicketHome (){if( ticketDao == null)ticketDao =new TicketHome ();return ticketDao;}
	public static UserInfoHome getUserInfoHome (){if( userInfoDao == null)userInfoDao =new UserInfoHome ();return userInfoDao;}
}
