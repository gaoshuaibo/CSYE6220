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
		<div id="content_1" class="span-12 last">
			<form action="/tht/account/register/restaurant" method="POST">
				<fieldset>
				<legend>Register Form</legend>
					<label for="name">Name:</label>
					<input type="text" name="name"><br>
					<label for="location">Location:</label>
					<c:forEach items="${location_list}" var="location_item">
						<input type="radio" name="locationid" value="${location_item.id}" checked="true">${location_item.name}
					</c:forEach><br>
					<label for="address">Address:</label>
					<input type="text" name="address"><br>
					<label for="email">Email:</label>
					<input type="email" name="email"><br>
					<label for="password">Password:</label>
					<input type="password" name="password"><br>
					<input type="hidden"
					    name="${_csrf.parameterName}"
					    value="${_csrf.token}"/>
				</fieldset>
				<input type="submit" value="Register">
			</form>
		</div>
	</div>
</body>
</html>