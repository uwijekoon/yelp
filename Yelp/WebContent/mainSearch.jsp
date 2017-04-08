<%@ include file="head.jsp" %>
<div class="app-container">
<div class="search-wrapper">
			<div class="search">
				<h2>Yelp Search</h2>
				<form action="QuerySearchServlet" method="get" id="queryForm">
					<div class="input-group">	
			            <input type="text" autocomplete="off" data-component-bound="true" aria-autocomplete="list"
			             class="form-control" name="query" id="query" placeholder="Start search">
			            <span class="input-group-btn">
					        <button type="button" class="searchbutton">
					          <span class="glyphicon glyphicon-search"></span>
					        </button>
					   </span>
					</div>					
				</form>
			</div>
		</div>
 </div>
<%@ include file="footer.jsp"%>
		
		