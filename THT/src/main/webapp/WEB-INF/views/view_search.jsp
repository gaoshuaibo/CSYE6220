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
		<table>
			<tr>
			<c:forEach items="${result}" var="dish">
			    <td>
			    	<c:if test="${user == null }"><a href = "/tht/dish/view/user?dishid=${dish.id}"></c:if>
			    	<c:if test="${user != null }"><a href = "/tht/dish/view/user?dishid=${dish.id}&userid=${user.id}"></c:if>
	 					<img height="200" width="200" alt="${dish.name}" src="/tht/${dish.image}"><br>
	 					Name: ${dish.name }<br>
	 					Price: ${dish.price }<br>
	 					Restaurant: ${dish.restaurant.name}<br>
	 					Calorie: ${dish.getCalorie() }<br>
	 					</a>
			  	</td>
			</c:forEach>
			</tr>
		</table>
		</div>
	</div>
</body>
</html>
