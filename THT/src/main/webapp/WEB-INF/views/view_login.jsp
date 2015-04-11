<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
</head>
<body>
	<div id="page_1">
		<div id="content_1">
		<c:if test="${go_to_welcome == null}">
			<form action="/tht/account/login/${role}" method="POST" name="login">
		</c:if>
		<c:if test="${go_to_welcome != null}">
			<form action="/tht/account/login/${role}?go_to_welcome=${go_to_welcome}" method="POST" name="login">
		</c:if>
			<label for="name">Name</label>
			<input type="text" name="username">
			<label for="password">Password</label>
			<input type="password" name="password">
			<input type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>
