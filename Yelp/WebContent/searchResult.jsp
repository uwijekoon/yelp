<%@ include file="head.jsp" %>
		<div class="app-container">
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
