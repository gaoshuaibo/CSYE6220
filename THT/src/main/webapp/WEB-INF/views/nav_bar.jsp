
	<div id="nav_bar">
		<header id="header_1">
			<div id="navbar_1" role="navigation">
				<div id="navbar_up">
					<div id="navbar_up_left">
						<a href="/tht/welcome">The Healthy Table</a>
					</div>
					<div id="navbar_up_middle">
						<a href="/tht/account/login/restaurant">I'm Restaurant</a>
						<a href="/tht/account/login/user">I'm Customer</a>
						<a href="/tht/account/register">Register</a>
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
		</header>
	</div>