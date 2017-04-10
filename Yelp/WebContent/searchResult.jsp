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
		
			<div class="issue-wrapper">
				<div class="issue-list-header">
					<h3>${sessionScope.headingStr}</h3>					
				</div>
				<!-- <div class="issue-list-filter">
					<div class="filter-header">Filter:</div>
					<div class="filter-item filter-selected" id="nearBy">Near by</div>
					<div class="filter-item" id="openNow">Open Now</div>					
				</div> -->
				<div class="issue-list-head">
					<div class="business-id">Name</div>
					<div class="issue-title">Address</div>
					<div class="issue-status">Stars</div>
				</div>
				<div class="issue-list">
					<%@ include file="searchBusinessList.jsp" %>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
