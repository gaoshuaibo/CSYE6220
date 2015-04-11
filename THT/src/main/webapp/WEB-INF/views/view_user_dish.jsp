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
			Name: ${dish.name}<br>
			<img height="300" width="300" alt="${dish.name}" src="/tht/${dish.image}"><br>
			Price: ${dish.price}<br>
			Restaurant: ${dish.restaurant.name}<br>
			Location: ${dish.restaurant.location.name}<br>
			Calorie: ${dish.getCalorie()}<br>
			Ingredients:<br>
			<table>
				<tr>
					<th>Name</th>
					<th>Calorie/lb</th>
					<th>Amount/lb</th>
				</tr>
				<c:forEach items="${dish.ingredients}" var="item">
					<tr>
					    <td>${item.ingredient.name}</td>
					    <td>${item.ingredient.calorie}</td>
					    <td>${item.amount}</td>
				  	</tr>
				</c:forEach>
			</table>
			<c:if test="${user == null}">
				<form action="/tht/account/login/user" method="GET">
			</c:if>
			<c:if test="${user != null}">
				<form action="/tht/cart/add?userid=${user.id}&dishid=${dish.id}&restaurantid=${restaurant.id}" method="POST">
			</c:if>
				<label for="quantity">Quantity</label>
				<input type="text" value name="quantity" autocomplete="off">
				<input type="submit" value="Add to Cart">
			</form>
		</div>
	</div>
</body>
</html>
