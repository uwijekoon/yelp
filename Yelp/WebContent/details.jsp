<%@ include file="head.jsp" %>
		<div class="issue-wrapper">
				<div class="issue-header">
					<h2>${business.name} </h2>
				</div>
				<div class="issue-details">
					<div class="row margin-bottom-20">
						<div class="issue-title">
							<div class="textDiv"><span class="colorFont">Address:</span><span>${business.address}</span></div>
							<div class="stars">
							<span>${business.stars} stars</span>
						</div>
						</div>
					</div>
					<div class="row margin-bottom-20">
						<div class="issue-title">
							<div class="textDiv"><span class="colorFont">City: </span><span>${business.city} </span></div>
							<div class="textDiv"><span class="colorFont">State: </span><span>${business.businessState} </span></div>
							<div class="textDiv"><span class="colorFont">Neighbourhood: </span><span>
							<c:if test="${empty business.neighbourhood}">
							N/A
							</c:if>
							<c:if test="${not empty business.neighbourhood}">
							${business.neighbourhood} 
							</c:if>
							</span></div>
						</div>
					</div>
					<div class="row margin-bottom-20">
						<div class="issue-title">
							<div class="textDiv"><span class="colorFont">Categories</span><br/>
							<c:forEach items="${business.categoryList}" var="category">
								${category}
							</c:forEach>
						</div>
					</div>
					<div class="row margin-bottom-20">
						<div class="issue-title">
							<div class="textDiv"><span class="colorFont">Open Hours</span><br/>
							<c:forEach items="${business.openHours}" var="hour">
								${hour.day} ${hour.fromTime}0-${hour.toTime}
							</c:forEach>
						</div>
					</div>
					<div class="row margin-bottom-20">
						<div class="issue-title">
							<div class="textDiv"><span class="colorFont">Reviews</span><br/>
							<c:forEach items="${business.reviews}" var="review">
								<span>User ${review.user.id} wrote on ${review.reviewDate} </span><br/>
								<span>stars: ${review.stars} Useful: ${review.useful} Funny: ${review.funny} Cool: ${review.cool}</span><br/>
								<span>${review.text}</span><br/><br/>
							</c:forEach>
						</div>
					</div>
					
					
				</div>
			</div>
<%@ include file="footer.jsp"%>
