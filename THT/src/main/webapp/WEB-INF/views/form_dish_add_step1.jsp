<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/form.css" />" rel="stylesheet"  type="text/css" />		
<%-- <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script> --%>
<%-- <script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	 --%>
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
				<h2>Step 1: Base Infomation</h2>
				<form action="/tht/dish/add/step1" method="POST">
					<label for="name">Name:</label>
					<input type="text" name="name"><br>
					<label for="price">Price:</label>
					<input type="number" name="price"><br>
					<input type="submit" value="Next Step">
									<input type="hidden"
				    name="${_csrf.parameterName}"
				    value="${_csrf.token}"/>
<%-- 					<input type="hidden" name="image_path" value="${new_image_name}"><br> --%>
				</form>
		</div>
	</div>
</body>
</html>