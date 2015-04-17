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
		<div id="content_1">
		<c:if test="${go_to_welcome == null}">
			<form action="/tht/account/login/${role}" method="POST" name="login">
		</c:if>
		<c:if test="${go_to_welcome != null}">
			<form action="/tht/account/login/${role}?go_to_welcome=${go_to_welcome}" method="POST" name="login">
		</c:if>
			<label for="name">Name</label>
			<input type="email" name="username">
			<label for="password">Password</label>
			<input type="password" name="password">
			<input type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>
