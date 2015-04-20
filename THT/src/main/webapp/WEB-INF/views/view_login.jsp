<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Signin</title>
<link rel="stylesheet" href="/tht/resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="/tht/resources/blueprint/print.css" type="text/css" media="print">
<link href="<c:url value="/resources/style/nav_bar.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/utl.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/style/login.css" />" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/scripts/nav_bar.js" />"></script>
</head>
<body>
	<div id="page_1">
		<div id="content_1">
			<div id="login_form">
				<div class ="span-12 last">
					<form action="<c:url value='/j_spring_security_check' />" method="POST">
						<fieldset>
							<p>
								<div id="logo"><img height="200" width="200" alt="The Healthy Table" src="/tht/resources/icons/THT.png"></div><br>
							</p>
							<p>
								<label	for="username" path="username">E-mail</label><br/>
								<input type="text" name="username" path="username"/>	
							</p>
							<p>
								<label	for="password" path="password">Password</label><br/>
								<input type="password" name="password" path="password"/>	
							</p>
							<p>
								<input name="submit" type="submit" value="Signin" />
							</p>
						<c:if test="${not empty error}">
							<div id="msg" class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div id="msg" class="msg">${msg}</div>
						</c:if>
						</fieldset>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
