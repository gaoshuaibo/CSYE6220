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
			<ul>
			<a href="/tht/dish/add?restaurantid=${restaurant.id}">Add dish</a><br>
			<c:forEach items="${dishes}" var="dish">
			    <li>
	 				<img height="200" width="200" alt="${dish.name}" src="/tht/${dish.image}"><br>
	 				Name: ${dish.name}<br>
	 				Price: ${dish.price}<br>
					<form action="/tht/dish/remove?restaurantid=${restaurant.id}&dishid=${dish.id}" method="POST" name="dish_remove">
						<input type="submit" value="Remove">
					</form>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
