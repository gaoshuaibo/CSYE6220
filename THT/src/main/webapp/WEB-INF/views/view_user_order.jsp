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
			<c:forEach items="${orders}" var="order">
				Order id: ${order.id} <br>
			    <li>
			    	<c:forEach items="${order.items}" var="item">
		 				<img height="100" width="100" alt="${item.dish.name}" src="/tht/${item.dish.image}"><br>
		 				Name: ${item.dish.name}<br>
		 				Quantity: ${item.quantity}<br>
		 				Ticket: ${item.ticket.code}<br>
		 				Expire Date: ${item.ticket.expiredate}<br>
					</c:forEach>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
