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
			Name: ${user.name}<br>
			Age: ${user.age}<br>
			<a href="/tht/order/view/user?userid=${user.id}">My orders</a><br>
			<a href="/tht/profile/view/user?userid=${user.id}">My profile</a><br>
			<a href="/tht/health/view/user?userid=${user.id}">My Healthy</a><br>
			<a href="/tht/account/logout/user?userid=${user.id}">Log out</a><br>
		</div>
	</div>
</body>
</html>
