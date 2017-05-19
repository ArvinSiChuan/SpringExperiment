function doStuListRefresh() {
	$.ajax({
		url: '../student/studetails',
		type: 'GET',
		async: true,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: {
			students:'all'
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
			sno:filteKey,
			sname:filteKey,
			sdept:filteKey,
		},

		success: function(data) {
			doTableRefresh(data);
		},
		error: function() {
			alert("error");
		}
	});
}

function doAjaxSubmit(){
	alert("OK");
}
