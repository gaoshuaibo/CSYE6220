<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="main_head">
		<header id="header_1">
			<div class="main_panel">
				<div class="left">
					<div id="logo"><img height="100" width="100" alt="The Healthy Table" src="/tht/resources/icons/THT.png"></div>
					<div id="the"><a href="/tht/welcome">The</a></div>
					<div id="healthy"><a href="/tht/welcome">Healthy</a></div>
					<div id="table"><a href="/tht/welcome">Table</a></div>		
				</div>
				<div class="middle">
					<div class="up">
						<ul>
							<li><a href="/tht/home">Your Account</a></li>
<!-- 							<li><a href="/tht/restaurant">TODO</a></li> -->
							<li><a>Register Now</a>
								<ul>
									<li><a href="/tht/account/register/user" class="first">I'm Customer</a></li>
									<li><a href="/tht/account/register/restaurant">I'm Restaurant</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="down">
							<div class="down_left">
								<form action="/tht/search" method="GET" name="home_search">
									<label id="search_label" for="keywords">Search</label>
									<input id="search_box" type="text" name="keyword" autocomplete="off">
									<c:if test="${user != null}"><input type="hidden" name="userid" value="${user.id}"></c:if>
									<input type="image" id="search_button" src="/tht/resources/icons/search.png" value="GO">
													<input type="hidden"
				    name="${_csrf.parameterName}"
				    value="${_csrf.token}"/>
								</form>
								<c:if test="${(user == null)&&(restaurant == null)&&(finance == null)}">
									<a href="/tht/welcome_login">Signin</a>
								</c:if>
								<c:if test="${user != null}">
					       			<a href="/tht/home">${user.name}</a>
									<a href="/tht/cart">Cart</a>
									
								<form id="signout_form" action="<c:url value="/j_spring_security_logout"/>" method="POST">
									<input type="hidden"
								    name="${_csrf.parameterName}"
								    value="${_csrf.token}"/>
								</form>
									
									<a href="javascript:document:signout_form.submit();">Signout</a>
<!-- 									<a href="/j_spring_security_logout">Signout</a> -->
								</c:if>
								<c:if test="${restaurant != null}">
					       			<a href="/tht/home">${restaurant.name}</a>
					       			<form id="signout_form_r" action="<c:url value="/j_spring_security_logout"/>" method="POST">
										<input type="hidden"
									    name="${_csrf.parameterName}"
									    value="${_csrf.token}"/>
									</form>
									
									<a href="javascript:document:signout_form_r.submit();">Signout</a>
								</c:if>
								<c:if test="${finance != null}">
					       			<a href="/tht/home">Finance</a>
					       			<form id="signout_form_r" action="<c:url value="/j_spring_security_logout"/>" method="POST">
										<input type="hidden"
									    name="${_csrf.parameterName}"
									    value="${_csrf.token}"/>
									</form>
									
									<a href="javascript:document:signout_form_r.submit();">Signout</a>
								</c:if>
							</div>
					</div>
				</div>
			</div>
		</header>
	</div>