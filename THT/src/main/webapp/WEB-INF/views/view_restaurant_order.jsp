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
			<% int index = 0; %>
			<table id="show_dish_panel">
				<tbody>
					<c:forEach items="${orderItems}" var="item">
					    <% if(index == 0) out.println( "<tr>");%>
					    <td>
					    	<fieldset>
					 			<img height="200" width="200" alt="${item.dish.name}" src="/tht/resources/images/${item.dish.image}"><br>
					 			Dish: ${item.dish.name}<br>
					 			Quantity: ${item.quantity}<br>
					 			Status: <c:if test="${item.used == 0}">Unused</c:if><c:if test="${item.used != 0}">Used<br> (${item.consumeTime})</c:if>
					 			<c:if test="${item.used == 0}">
						 			<form action="/tht/order/consume?itemid=${item.id}" method="POST">
							 			<label for="ticket">Confirm Ticket: </label><br>
							 			<input type="text" name="code">
							 			<input type="submit" value="Check">
							 													<input type="hidden"
							    name="${_csrf.parameterName}"
							    value="${_csrf.token}"/>
						 			</form>
					 			</c:if>
					 		</fieldset>
					  	</td>
					  	<% if(index == 5) {
					  			out.println("</tr>");
					  			index = 0;
					  		}else{
					  			index++;} %>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>
