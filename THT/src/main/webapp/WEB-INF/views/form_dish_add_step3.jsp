<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/form.css" />" rel="stylesheet"  type="text/css" />		
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	
<link href="<c:url value="/resources/style/nav_bar.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			  <script type="text/javascript">
			  	setSearchBoxWidth();
			  </script>
			  	<h2>Step 3: Add Ingredients</h2>
					<form action="/tht/dish/add/step3?restaurantid=${restaurant.id}" method="POST">
						<c:forEach items="${ingredients}" var="ingredient">
							<label><input type="checkbox" name="ingredient_selected" value="${ingredient.id}">${ingredient.name}</label>
							<label>Amount:<input type="number" name="amount"></label>
							<br>
						</c:forEach>
						<input type="hidden" name="dishname" value="${dishname}"><br>
						<input type="hidden" name="dishprice" value="${dishprice}"><br>
						<input type="hidden" name="dishimage" value="${dishimage}"><br>
						<input type="submit" value="Commit">
					</form>
		</div>
	</div>
</body>
</html>