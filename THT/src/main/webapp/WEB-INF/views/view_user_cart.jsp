<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
			<ul>
			<c:forEach items="${cart_items}" var="item">
			    <li>
	 				<img height="100" width="100" alt="${item.dish.name}" src="/tht/resources/images/${item.dish.image}"><br>
	 				Name: ${item.dish.name}<br>
	 				Quantity: ${item.quantity}<br>
					<form action="/tht/cart/remove?userid=${user.id}&itemid=${item.id}" method="POST" name="cart_remove">
						<input type="submit" value="Remove">
					</form>
				</li>
			</c:forEach>
			</ul>
			<form action="/tht/payment" method="GET">
				<input type="hidden" value="${user.id}" name="userid">
				<input type="submit" value="Place Order">
			</form>
		</div>
	</div>
</body>
</html>
