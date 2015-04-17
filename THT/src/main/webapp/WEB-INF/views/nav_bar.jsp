

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
							<li><a href="/tht/account/login/user">I'm Customer</a></li>
							<li><a href="/tht/account/login/restaurant">I'm Restaurant</a></li>
							<li><a href="/tht/account/register">Register Now</a>
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
								</form>
								<c:if test="${user == null}">
									<a href="/tht/account/login/user?go_to_welcome=1">Login</a>
					       			<a href="/tht/account/login/user?go_to_welcome=1">Cart</a>
								</c:if>
								<c:if test="${user != null}">
					       			<a href="/tht/user?userid=${user.id}">${user.name}</a>
									<a href="/tht/cart?userid=${user.id}">Cart</a>
								</c:if>
							</div>
					</div>
				</div>
			</div>
		</header>
	</div>