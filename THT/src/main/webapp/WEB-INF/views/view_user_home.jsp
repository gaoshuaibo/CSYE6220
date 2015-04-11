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
			Name: ${user.name}<br>
			Age: ${user.age}<br>
			<a href="/tht/order/view/user?userid=${user.id}">My orders</a><br>
			<a href="/tht/profile/view/user?userid=${user.id}">My profile</a><br>
			<a href="/tht/profile/view/user?userid=${user.id}">My Healthy</a><br>
		</div>
	</div>
</body>
</html>
