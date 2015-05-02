<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css"
	type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css"
	type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
		<h2 style="color:red;">Total Calorie:${total_calorie }</h2>
			<table id="show_dish_panel">
				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr>
							<div>
								<fieldset><legend>Order id: ${order.id}</legend>
									<c:forEach items="${order.items}" var="item">
										<div style="float: left; font-size: 18px;">
													<img style="margin-right: 20px;" height="200" width="200" alt="${item.dish.name}"
														src="/tht/resources/images/${item.dish.image}"><br>
													Dish: ${item.dish.name}<br> 
													Price: ${item.dish.price}<br>	
													Calorie Unit: ${item.dish.getCalorie()}<br>	
													Quantity: ${item.quantity}<br>
													Status:
													<c:if test="${item.used == 0}">Unused</c:if>
													<c:if test="${item.used != 0}">Used<br>
													(${item.consumeTime})</c:if>
													<br> Ticket: ${item.ticket.code}
													<br> <p style="color:red;">Calorie: ${item.getComsumedCalorie()+item.getUncomsumedCalorie()}</p>
										</div>
									</c:forEach>
								</fieldset>
							</div>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
