					<%@ include file="tagLib.jsp" %>
					<c:forEach items="${sessionScope.recommendList}" var="business">
  				<a class="issue" href="BusinessDetails?id=<c:out value="${business.id}"/>">
    			<div class="business-id">
    				<span>${business.name}</span>
    			</div>
    			<div class="issue-title"><c:out value="${business.address}"/></div>
    			<div class="">${business.stars}</div>
			  </a>
				</c:forEach>