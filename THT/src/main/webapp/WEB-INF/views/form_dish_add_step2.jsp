<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/form.css" />" rel="stylesheet"  type="text/css" />		
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	
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
			  	<h2>Step 2: Upload Image</h2>
			  	<form id="fileuploadForm" action="/tht/form_dish_add_step2" method="POST" enctype="multipart/form-data">
					<c:if test="${not empty message}">
						<div id="message" class="success">${message}</div>	  		
			  		</c:if>
					
					<input type="hidden" name="restaurantid" value="${restaurant.id}"><br>
					<input type="hidden" name="dishname" value="${dishname}"><br>
					<input type="hidden" name="dishprice" value="${dishprice}"><br>
					
					<c:if test="${dishimage == null}">
					<label for="image">Image:</label>
					<input type="file" name="image" id="image"><br>
					<input type="submit" value="Upload">
					</c:if>
				</form>
				<c:if test="${dishimage != null}">
					<img height="300" width="300" alt="${dishname}" src="/tht/resources/images/${dishimage}"><br>
					<form action="/tht/dish/add/step2?restaurantid=${restaurant.id}" method="POST">
						<input type="hidden" name="dishname" value="${dishname}"><br>
						<input type="hidden" name="dishprice" value="${dishprice}"><br>
						<input type="hidden" name="dishimage" value="${dishimage}"><br>
						<input type="submit" value="Next Step">
					</form>
				</c:if>
				<script type="text/javascript">
					$(document).ready(function() {
						$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#image"));
						$("#fileuploadForm").ajaxForm({ success: function(html) {
								$("#page_1").replaceWith(html);
							}
						});
					});
				</script>
		</div>
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>