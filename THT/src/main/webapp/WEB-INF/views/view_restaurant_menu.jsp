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
			<a href="/tht/dish/add?restaurantid=${restaurant.id}">Add dish</a><br>
			<c:forEach items="${dishes}" var="dish">
			    <li>
	 				<img height="200" width="200" alt="${dish.name}" src="/tht/resources/images/${dish.image}"><br>
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
