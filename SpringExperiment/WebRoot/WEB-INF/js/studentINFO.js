$(document).ready(function() {
	doStuListRefresh();
	$('#btn0').click(function() {
		doStuListRefresh();
	});
	$("#filter").keyup(function() {
		var value = $("#filter").val();
		var historyValue = $("#filterHistory").val();
		if(historyValue != value) {
			doFilter(value);
			$("#filterHistory").val(value);
		}
	})
	$("#newStuBtn").click(function() {
		$("#newStuDiv").toggle();
	});
	$("#newStu").focus(function() {
		$("#newStuDiv").show();
	}).blur(function() {
		$("#newStuDiv").hide();
	});
});

function doStuListRefresh() {
	$.ajax({
		url: '../student/studetails',
		type: 'GET',
		async: true,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: {
			students: 'all'
		},

		success: function(data) {
			doTableRefresh(data);
		},
		error: function() {
			alert("connection timeout");
		}
	});
}

function doTableRefresh(data) {

	$("#studentsINFO").html("<table style='margin:auto;text-align:center;'><tr><th>SNo</th><th>SName</th><th>SDept</th></tr></table>");
	$.each(data, function(i, item) {
		$("#studentsINFO").find("tr:last").after("<tr id='" + item.sno + "'>" +
			"<td>" + item.sno + "</td>" +
			"<td>" + item.sname + "</td>" +
			"<td>" + item.sdept + "</td>" +
			"<td><input type='button' value='delete' onclick='doStuDelete(" + item.sno + ")' /></td></tr>");
		$("#studentsINFO").find("tr:last").animate({
			fontSize: "+=1em"
		});

		$("#studentsINFO").find("tr:last").animate({
			fontSize: "-=1em"
		});
	});
}

function doStuDelete(sno) {
	$.ajax({
		url: '../student/studetails',
		type: 'DELETE',
		async: true,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: "{'sno':'" + sno + "'}",

		success: function() {
			$("tr#" + sno + "").fadeIn("slow").remove();
		},
		error: function() {
			alert("error");
		}
	});
}

function doFilter(filteKey) {

	$.ajax({
		url: '../student/stufilter',
		type: 'GET',
		async: true,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: {
			sno: filteKey,
			sname: filteKey,
			sdept: filteKey,
		},

		success: function(data) {
			doTableRefresh(data);
		},
		error: function() {
			alert("error");
		}
	});

}

function doAjaxSubmit() {
	var tempData = $("#newStu").serializeArray();
	var stuData = {};
	for(var item in tempData) {
		stuData[tempData[item].name] = tempData[item].value;
	}
	var sno = stuData.sno;
	console.log("INfo" + stuData);
	$.ajax({
		url: '../student/stunew',
		type: 'POST',
		async: true,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: JSON.stringify(stuData),

		success: function(data) {
			doTableRefresh(data);
			$("#" + sno + "").animate({
					opacity: '0.2'
				}, "slow")
				.animate({
					opacity: '1'
				}, "slow")
				.animate({
					opacity: '0.2'
				}, "slow")
				.animate({
					opacity: '1'
				}, "slow")
				.animate({
					opacity: '0.2'
				}, "slow")
				.animate({
					opacity: '1'
				}, "slow");
		},
		error: function() {
			alert("error");
		}
	});
	return false;
}