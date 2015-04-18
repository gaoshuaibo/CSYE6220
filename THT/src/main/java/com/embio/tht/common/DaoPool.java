package com.embio.tht.common;

import com.embio.tht.beans.*;

public final class DaoPool {
	private static UsersHome usersDao;
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
	private static CustomerHome customerDao;
	private static AuthoritiesHome authoritiesDao;
	
	public static UsersHome getUsersDao (){if( usersDao == null)usersDao =new UsersHome ();return usersDao;}
	public static AllergyHome getAllergyDao (){if( allergyDao == null)allergyDao =new AllergyHome ();return allergyDao;}
	public static CalorieHome getCalorieDao (){if( calorieDao == null)calorieDao =new CalorieHome ();return calorieDao;}
	public static CardsHome getCardsDao (){if( cardsDao == null)cardsDao =new CardsHome ();return cardsDao;}
	public static CartItemHome getCartItemDao (){if( cartItemDao == null)cartItemDao =new CartItemHome ();return cartItemDao;}
	public static CartItemUnitHome getCartItemUnitDao (){if( cartItemUnitDao == null)cartItemUnitDao =new CartItemUnitHome ();return cartItemUnitDao;}
	public static DishHome getDishDao (){if( dishDao == null)dishDao =new DishHome ();return dishDao;}
	public static DishIngredientItemHome getDishIngredientItemDao (){if( dishIngredientItemDao == null)dishIngredientItemDao =new DishIngredientItemHome ();return dishIngredientItemDao;}
	public static EatingHabbitHome getEatingHabbitDao (){if( eatingHabbitDao == null)eatingHabbitDao =new EatingHabbitHome ();return eatingHabbitDao;}
	public static FinanceItemHome getFinanceItemDao (){if( financeItemDao == null)financeItemDao =new FinanceItemHome ();return financeItemDao;}
	public static IngredientHome getIngredientDao (){if( ingredientDao == null)ingredientDao =new IngredientHome ();return ingredientDao;}
	public static LocationHome getLocationDao (){if( locationDao == null)locationDao =new LocationHome ();return locationDao;}
	public static OrderInfoHome getOrderInfoDao (){if( orderInfoDao == null)orderInfoDao =new OrderInfoHome ();return orderInfoDao;}
	public static OrderItemHome getOrderItemDao (){if( orderItemDao == null)orderItemDao =new OrderItemHome ();return orderItemDao;}
	public static OrderItemDishHome getOrderItemDishDao (){if( orderItemDishDao == null)orderItemDishDao =new OrderItemDishHome ();return orderItemDishDao;}
	public static PaymentHome getPaymentDao (){if( paymentDao == null)paymentDao =new PaymentHome ();return paymentDao;}
	public static RestaurantHome getRestaurantDao (){if( restaurantDao == null)restaurantDao =new RestaurantHome ();return restaurantDao;}
	public static RoleHome getRoleDao (){if( roleDao == null)roleDao =new RoleHome ();return roleDao;}
	public static SurveyHome getSurveyDao (){if( surveyDao == null)surveyDao =new SurveyHome ();return surveyDao;}
	public static SystemInfoHome getSystemInfoDao (){if( systemInfoDao == null)systemInfoDao =new SystemInfoHome ();return systemInfoDao;}
	public static TicketHome getTicketDao (){if( ticketDao == null)ticketDao =new TicketHome ();return ticketDao;}
	public static CustomerHome getCustomerDao (){if( customerDao == null)customerDao =new CustomerHome ();return customerDao;}
	public static AuthoritiesHome getAuthoritiesDao (){if( authoritiesDao == null)authoritiesDao =new AuthoritiesHome ();return authoritiesDao;}
}
