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
			<c:forEach items="${orderItems}" var="item">
			    <li>
		 			<img height="100" width="100" alt="${item.dish.name}" src="/tht/resources/images/${item.dish.image}"><br>
		 			Name: ${item.dish.name}<br>
		 			Quantity: ${item.quantity}<br>
		 			Status: <c:if test="${item.used == 0}">Unused</c:if><c:if test="${item.used != 0}">Used (${item.consumeTime})</c:if>
		 			<c:if test="${item.used == 0}">
			 			<form action="/tht/order/consume?itemid=${item.id}" method="POST">
				 			<label for="ticket">Confirm Ticket: </label>
				 			<input type="text" name="code">
				 			<input type="submit" value="Check">
				 													<input type="hidden"
				    name="${_csrf.parameterName}"
				    value="${_csrf.token}"/>
			 			</form>
		 			</c:if>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
