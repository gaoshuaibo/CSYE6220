<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
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
					<c:forEach items="${dishes}" var="dish">
					    <% if(index == 0) out.println( "<tr>");%>
					    <td>
					    	<a href = "/tht/dish/viewdetails?dishid=${dish.id}" id="a_dish">
			 					<img height="250" width="250" alt="${dish.name}" src="/tht/resources/images/${dish.image}"><br>
			 					Name: ${dish.name }<br>
			 					Price: ${dish.price }<br>
			 					Restaurant: ${dish.restaurant.name}<br>
			 					<p id="p_calorie">Calorie: ${dish.getCalorie() }</p><br>
			 					</a>
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
