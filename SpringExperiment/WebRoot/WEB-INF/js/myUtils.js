
// CSRF Defence header producer
function getHeaderToken() {
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	var headerToken = {};
	headerToken[header]=token;
	return headerToken;
}


function doTwinkleAnimate(target, times) {
	for(var i = 0; i < times; i++) {
		$(target).animate({
				opacity: '0.2'
			}, "slow")
			.animate({
				opacity: '1'
			}, "slow");
	}
}

function ajaxError(data){
	switch (data.status){
		case 403:
			location.href="/SpringExperiment/logout/";
			break;
		default:
			location.href="/SpringExperiment/logout/";
			break;
	}
}
