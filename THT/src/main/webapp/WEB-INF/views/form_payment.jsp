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
			<form action="/tht/payment/commit" method="POST">
				<label for="cardid">Card Id:</label>
				<input type="number" name="cardid"><br>
				<label for="expiredate">Expire Month:</label>
				<input type="number" min="1" max="12" name="expiremonth">
				<label for="expiredate">Year:</label>
				<input type="number" min="2016" max="2026" name="expireyear"><br>
								<input type="hidden"
				    name="${_csrf.parameterName}"
				    value="${_csrf.token}"/>
				<input type="submit" value="Place Order">
			</form>
		</div>
	</div>
</body>
</html>
