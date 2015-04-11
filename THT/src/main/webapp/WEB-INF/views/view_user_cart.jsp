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
			<c:forEach items="${cart_items}" var="item">
			    <li>
	 				<img height="100" width="100" alt="${item.dish.name}" src="/tht/${item.dish.image}"><br>
	 				Name: ${item.dish.name}<br>
	 				Quantity: ${item.quantity}<br>
					<form action="/tht/cart/remove?userid=${user.id}&itemid=${item.id}" method="POST" name="cart_remove">
						<input type="submit" value="Remove">
					</form>
				</li>
			</c:forEach>
			</ul>
			<form action="/tht/order/place?userid=${user.id}" method="POST" name="order_place">
				<input type="submit" value="Place Order">
			</form>
		</div>
	</div>
</body>
</html>
