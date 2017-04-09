<%@ include file="head.jsp" %>
<div class="app-container">
<div class="login-wrapper">
			<div class="login">
				<h2>Log In</h2>
				<form action="LoginServlet" method="get" id="loginForm">
					<div class="input-group">
						
						<div class="input-subgroup">
						<input type="text" placeholder="User ID" name="userId" value="${userId}">
						</div>
					</div>
					<div class="input-group">
						<div class="input-subgroup">
						<input type="text" placeholder="Longitude" name="longitude">
						</div>
					</div>
					
					<div class="input-group">
						<div class="input-subgroup">
						<input type="text" placeholder="Latitude" name="latitude">
						</div>
					</div>
					<button type="submit">Login</button>
				</form>
			</div>
		</div>
 </div>
<%@ include file="footer.jsp"%>