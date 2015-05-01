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

<script src="<c:url value="/resources/jquery-2.1.3/jquery.js"/>"></script>
<script src="<c:url value="/resources/ckeditor/ckeditor.js"/>"></script>
<script src="<c:url value="/resources/ckeditor/adapters/jquery.js"/>"></script>
<script type="text/javascript">
	$(document).ready( function(){
		$("textarea").ckeditor();
	});
</script>

</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			<h2>${dish.name}</h2><br>
			<table style="width:600px;">
				<tr>
					<td>
						<img height="300" width="300" alt="${dish.name}" src="/tht/resources/images/${dish.image}"><br>
					</td>
					<td>
						<p id="p_view_dish">
							Price: ${dish.price}<br>
							Restaurant: ${dish.restaurant.name}<br>
							Location: ${dish.restaurant.location.name}
							<p id="p_view_dish" style="color:red;">Calorie: ${dish.getCalorie()}</p>
							Ingredients:<br>
						</p>
						<table style="width:500px;">
							<tr>
								<th>Name</th>
								<th>Calorie/lb</th>
								<th>Amount/lb</th>
							</tr>
							<c:forEach items="${dish.ingredients}" var="item">
								<tr>
								    <td>${item.ingredient.name}</td>
								    <td>${item.ingredient.calorie}</td>
								    <td>${item.amount}</td>
							  	</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
			
			

			<c:if test="${customer == null}">
				<input type="submit" disabled="disabled" value="Please login as customer to add this dish to cart"/>
			</c:if>
			<c:if test="${customer != null}">
				<form action="/tht/cart/add?dishid=${dish.id}&restaurantid=${dish.restaurant.id}" method="POST">
					<label for="quantity">Quantity</label>
					<input type="number" max="999" min="1" value name="quantity">
					<input type="hidden"
					    name="${_csrf.parameterName}"
					    value="${_csrf.token}"/>
					<input type="submit" value="Add to Cart">
				</form>
			</c:if>

			<table>
				<tr>
					<th>Reivews</th>
				</tr>
					<c:forEach items="${reviews}" var="aaa">
						<tr>
							<td>
								<p>${aaa.getTrent()}</p>
							</td>
						</tr>
					</c:forEach>
			</table>

			<c:if test="${customer != null}">
				<form action="/tht/dish/review/add?dishid=${dish.id}" method="POST">
					<label for="review_text">Write your own reviews</label><br/>
					<textarea name="review_text"></textarea><br/>
					<input type="hidden"
					    name="${_csrf.parameterName}"
					    value="${_csrf.token}"/>
					<input type="submit" value="Submit Review">
				</form>
			</c:if>

		</div>
	</div>
</body>
</html>
