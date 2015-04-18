<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			Name: ${dish.name}<br>
			<img height="300" width="300" alt="${dish.name}" src="/tht/resources/images/${dish.image}"><br>
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
			<form action="/tht/cart/add?dishid=${dish.id}&restaurantid=${dish.restaurant.id}" method="POST">
				<label for="quantity">Quantity</label>
				<input type="text" value name="quantity">
				<input type="hidden"
				    name="${_csrf.parameterName}"
				    value="${_csrf.token}"/>
				<input type="submit" value="Add to Cart">
			</form>
		</div>
	</div>
</body>
</html>
