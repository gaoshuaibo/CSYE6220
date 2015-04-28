<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<!-- 	<!-- 	am crying now! --> -->
<%--     <meta name="_csrf" content="${_csrf.token}"/> --%>
<!--     default header name is X-CSRF-TOKEN -->
<%--     <meta name="_csrf_header" content="${_csrf.headerName}"/> --%>
    
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
		<div id="content_1" class="span-12 last">
			  <script type="text/javascript">
			  	setSearchBoxWidth();
			  </script>
			  	<h2>Step 2: Upload Image</h2>
			  	
			  	<c:if test="${dishimage == null}">
			  		<form id="fileuploadForm" action="/tht/form_dish_add_step2?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
						<c:if test="${not empty message}">
							<div id="message" class="success">${message}</div>	  		
				  		</c:if>
				  		<fieldset>
				  		<legend>Image</legend>
							<input type="hidden" name="dishname" value="${dishname}"><br>
							<input type="hidden" name="dishprice" value="${dishprice}"><br>
							
							
							<label for="image">Image:</label>
							<input type="file" name="image" id="image"><br>
						</fieldset>
<!-- 						<input type="hidden" -->
<%-- 							    name="${_csrf.parameterName}" --%>
<%-- 							    value="${_csrf.token}"/> --%>
						<input type="submit" value="Upload">
					</form>
				</c:if>
				
				<c:if test="${dishimage != null}">
					<img height="300" width="300" alt="${dishname}" src="/tht/resources/images/${dishimage}"><br>
					<form action="/tht/dish/add/step2" method="POST">
						<input type="hidden" name="dishname" value="${dishname}"><br>
						<input type="hidden" name="dishprice" value="${dishprice}"><br>
						<input type="hidden" name="dishimage" value="${dishimage}"><br>
						<input type="submit" value="Next Step">
						<input type="hidden"
							    name="${_csrf.parameterName}"
							    value="${_csrf.token}"/>
					</form>
				</c:if>
		</div>
	</div>
</body>
</html>