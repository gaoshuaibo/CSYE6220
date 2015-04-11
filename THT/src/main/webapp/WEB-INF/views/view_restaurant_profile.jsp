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
			Name: ${restaurant.name}<br>
			Location: ${location.name}<br>
			Address: ${restaurant.address}<br>
		</div>
	</div>
</body>
</html>
