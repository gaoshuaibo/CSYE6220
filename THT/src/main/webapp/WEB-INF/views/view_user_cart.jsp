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
			<h2 style="color:red;">Total Calorie:${total_calorie }</h2>
			<form action="/tht/payment" method="GET">
				<input type="submit" value="Place Order">
			</form><br>
			<table id="show_dish_panel">
				<tbody>
					<c:forEach items="${cart_items}" var="item">
					    <% if(index == 0) out.println( "<tr>");%>
					    <td>
						    <fieldset>
				 				<img height="200" width="200" alt="${item.dish.name}" src="/tht/resources/images/${item.dish.image}"><br>
				 				Name: ${item.dish.name}<br>
				 				Restaurant: ${item.restaurant.name}<br>
				 				Price: ${item.dish.price}<br>
				 				Calorie Unit: ${item.dish.getCalorie()}<br>
				 				Quantity: ${item.quantity}<br>
				 				<p style="color:red;">Calorie: ${item.getCalorie()}</p>
								<form action="/tht/cart/remove?itemid=${item.id}" method="POST" name="cart_remove">
									<input type="submit" value="Remove">
													<input type="hidden"
							    name="${_csrf.parameterName}"
							    value="${_csrf.token}"/>
								</form>
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
