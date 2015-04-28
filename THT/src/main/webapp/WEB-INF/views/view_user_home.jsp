<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css"
	type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css"
	type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			<div id="div_home">
				<%-- 			Name: ${user.name}<br> --%>
				<%-- 			Age: ${user.age}<br> --%>
				<a href="/tht/cart">My Cart</a><br> <a
					href="/tht/order/view/user">Your orders</a><br> <a
					href="/tht/profile/view/user">Your profile</a><br> <a
					href="/tht/health/view/user">Your Healthy</a><br> 
					       			<form id="signout_form_r" action="<c:url value="/j_spring_security_logout"/>" method="POST">
										<input type="hidden"
									    name="${_csrf.parameterName}"
									    value="${_csrf.token}"/>
									</form>
									
									<a href="javascript:document:signout_form_r.submit();">Signout</a>
			</div>
		</div>
	</div>
</body>
</html>
