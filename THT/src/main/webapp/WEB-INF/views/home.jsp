<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>The Healthy Table - Home</title>
</head>
<body>
	<div id="page_1">
		<header id="header_1">
			<div id="navbar_1" role="navigation">
				<div id="navbar_up">
					<div id="navbar_up_left">
						<a href="/home">The Healthy Table</a>
					</div>
					<div id="navbar_up_middle">
						<a href="/menu1">My Account</a>
						<a href="/menu2">menu2</a>
						<a href="/menu3">menu3</a>
					</div>
					<div id="navbar_up_right">This is right part</div>
				</div>
				<div id="navbar_down">
					<div id="navbar_down_left">
						This is left part
					</div>
					<div id="navbar_down_middle">
						<label id="navbar_down_middle_search_label" for="home_search_input">Search</label>
						<div id="navbar_down_middle_search_button">
							<form action="/search" method="GET" name="home_search">
								<div id="navbar_down_middle_search_button">
									<input type="submit" value="go">
								</div>
							</form>
						</div>
						<div id="navbar_down_middle_search_input">
							<input type="text" id="home_search_input" value name="keywords" autocomplete="off">
						</div>
					</div>
					<div id="navbar_down_right">
						<c:if test="${user == null}">
       						<a href="login">Login</a>
       						<a href="login">Cart</a>
						</c:if>
						<c:if test="${user != null}">
       						<a href="/tht/user?userid=${user.id}">${user.name}</a>
							<a href="/tht/cart?userid=${user.id}">Cart</a>
						</c:if>
					</div>
				</div>
			</div>
		</header>
		<div id="content_1">
		
		<table>
			<tr>
			<c:forEach items="${dishes}" var="dish">
			    <td>
			    	<c:if test="${user == null }"><a href = "/tht/viewdish?dishid=${dish.id}"></c:if>
			    	<c:if test="${user != null }"><a href = "/tht/viewdish?dishid=${dish.id}&userid=${user.id}"></c:if>
	 					<img height="200" width="200" alt="${dish.name}" src="/tht/${dish.image}">
	 				</a>
			  </tr>
			</c:forEach>
			</td>
		</table>
		</div>
	</div>
</body>
</html>
