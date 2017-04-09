$(document).ready(function(){
	$('.filter-item').click(function(){
		if($(this).hasClass('filter-selected')){
			$(this).removeClass('filter-selected');
		}else{
			$(this).addClass('filter-selected');
		}
		var nearBy = $('#nearBy').hasClass('filter-selected');
		var openNow = $('#openNow').hasClass('filter-selected');
		var data = {nearBy: nearBy, openNow:openNow, isFilter:true};
		sendAjax("POST", "RecommendServlet", data, loadIssuesSuccess, loadIssuesFailed);
	});
});


function loadIssuesSuccess(msg) {
	$("#recommend-list").empty();
	$("#recommend-list").append(msg);
}

function loadIssuesFailed(msg){
	console.log(msg.status);
	if (msg.status==401) {
		window.location = '/';
	}
}

