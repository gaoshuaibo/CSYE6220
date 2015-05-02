<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>The Healthy Table - Home</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/scripts/nav_bar.js" />"></script>

<script src="<c:url value="/resources/jquery-2.1.3/jquery.js"/>"></script>
<script src="<c:url value="/resources/ckeditor/ckeditor.js"/>"></script>
<script src="<c:url value="/resources/ckeditor/adapters/jquery.js"/>"></script>
<script type="text/javascript">
	$(document).ready( function(){
		$("textarea").ckeditor();
	});
</script>

</head>
<body onload="setSearchBoxWidth();" onresize="setSearchBoxWidth();">
	<div id="page_1">
		<%@ include file="nav_bar.jsp"%>
		<div id="content_1">
			<h3>Balance: ${balance}</h3>
			<table>
				<tr>
					<th>Finance Id</th>
					<th>Order Id</th>
					<th>Income</th>
					<th>Outcome</th>
				</tr>
					<c:forEach items="${items}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.orderId}</td>
							<td>${item.income}</td>
							<td>${item.outcome}</td>
						</tr>
					</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td style="background-color: green;">Balance: ${balance}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
