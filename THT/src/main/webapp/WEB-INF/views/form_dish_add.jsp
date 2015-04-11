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
			<form action="/tht/dish/add?restaurantid=${restaurant.id}" method="POST">
				<label for="name">Name:</label>
				<input type="text" name="name"><br>
				<label for="price">Price:</label>
				<input type="number" name="price"><br>
				<label for="image">Image:</label>
				<input type="text" name="image" value="resources/images/1.jpg"><br>
					
				<input type="submit" value="Add dish">
			</form>
<!-- 				<form id="fileuploadForm" action="/tht/fileupload" method="POST" enctype="multipart/form-data"> -->
<%-- 				  	<c:if test="${not empty message}"> --%>
<%-- 						<div id="message" class="success">${message}</div>	  		 --%>
<%-- 				  	</c:if> --%>
<!-- 					<label for="image">Image:</label> -->
<!-- 					<input type="file" name="image" /> -->
<!-- 					<p><button type="submit">Upload</button></p>		 -->
<!-- 				</form> -->
<!-- 				<script type="text/javascript"> -->
<!-- // 					$(document).ready(function() { -->
<!-- // 						$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#image")); -->
<!-- // 						$("#fileuploadForm").ajaxForm({ success: function(html) { -->
<!-- // 								$("#content_1").replaceWith(html); -->
<!-- // 							} -->
<!-- // 						}); -->
<!-- // 					}); -->
<!-- 				</script> -->
		</div>
	</div>
<%-- <c:if test="${!ajaxRequest}"> --%>
</body>
</html>
<%-- </c:if> --%>
