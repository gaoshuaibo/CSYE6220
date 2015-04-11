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
			<c:forEach items="${orderItems}" var="item">
			    <li>
		 			<img height="100" width="100" alt="${item.dish.name}" src="/tht/${item.dish.image}"><br>
		 			Name: ${item.dish.name}<br>
		 			Quantity: ${item.quantity}<br>
		 			Status: <c:if test="${item.consumeTime == null}">Unused</c:if><c:if test="${item.consumeTime != null}">Used (${item.consumeTime})</c:if>
		 			<form action="/tht/order/consume?restaurantid=${restaurant.id}&itemid=${item.id}" method="POST">
			 			<label for="ticket">Confirm Ticket: </label>
			 			<input type="text" name="code">
			 			<input type="submit" value="Check">
		 			</form>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
