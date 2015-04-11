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
			Gender: ${user.gender}<br>
			Age: ${user.age}<br>
			Location: ${user.name}<br>
			Address: ${user.address}<br>
		</div>
	</div>
</body>
</html>
