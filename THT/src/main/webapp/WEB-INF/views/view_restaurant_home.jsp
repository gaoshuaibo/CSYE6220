<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
</head>
<body>
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			Name: ${restaurant.name}<br>
			Address: ${restaurant.address}<br>
			<a href="/tht/order/view/restaurant?restaurantid=${restaurant.id}">My orders</a><br>
			<a href="/tht/profile/view/restaurant/?restaurantid=${restaurant.id}">My profile</a><br>
			<a href="/tht/dish/view/restaurant/?restaurantid=${restaurant.id}">My menu</a><br>
		</div>
	</div>
</body>
</html>
