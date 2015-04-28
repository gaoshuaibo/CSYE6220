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
		<a href="/tht/dish/add"><h2>Add dish</h2></a><br>
			<% int index = 0; %>
			<table id="show_dish_panel">
				<tbody>
					<c:forEach items="${dishes}" var="dish">
					    <% if(index == 0) out.println( "<tr>");%>
					    <td>
					    	<fieldset><legend>Dish: ${dish.name}</legend>
				 				<img height="200" width="200" alt="${dish.name}" src="/tht/resources/images/${dish.image}"><br>
				 				Price: ${dish.price}
				 				<p style="color:red;">Calorie: ${dish.getCalorie()}</p>
								<form action="/tht/dish/remove?dishid=${dish.id}" method="POST" name="dish_remove">
									<input type="submit" value="Remove">
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
