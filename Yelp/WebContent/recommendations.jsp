<%@ include file="head.jsp" %>
<script src="resources/js/recommendations.js" type="text/javascript"></script>
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
		
			<div class="issue-wrapper">
				<div class="issue-list-header">
					<h2>Recommended For You</h2>
					
				</div>
				<div class="issue-list-filter">
					<div class="filter-header">Filter:</div>
					<div class="filter-item" id="nearBy">Near by</div>
					<div class="filter-item" id="openNow">Open Now</div>
				</div>
				<div class="issue-list-head">
					<div class="business-id">Name</div>
					<div class="issue-title">Address</div>
					<div class="issue-status">Stars</div>
				</div>
				<div class="issue-list" id="recommend-list">
					<%@ include file="recommendationList.jsp" %>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
