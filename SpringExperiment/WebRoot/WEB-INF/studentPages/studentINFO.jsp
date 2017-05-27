<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>  
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8"/>
		<security:csrfMetaTags/>
		<title></title>
		<script src="/SpringExperiment/js/jquery.min.js"></script>
		<script src="/SpringExperiment/js/myUtils.js"></script>
		<script src="/SpringExperiment/js/studentINFO.js"></script>
	</head>

	<body style="text-align: center;">
		<div id="studentsINFO" style="text-align: center;"></div>
		<div id="operations">
			<input type="text" id="filter" placeholder="sno, sname or sdept" />
			<input type="button" id="btn0" value="refresh list" />
			<input type="text" id="filterHistory" hidden="hidden" />
		</div>
		<input href="#newStuBtn" id="newStuBtn" type="button" value="new student"></input>
		<div id="newStuDiv" style="position: relative;" hidden="hidden">
			<form id="newStu" action="#" onsubmit="return doAjaxSubmit();">
				<input id="sno" name="sno" type="number" placeholder="student number" />
				<input id="sname" name="sname" type="text" placeholder="studnet name" />
				<input id="sdept" name="sdept" type="number" placeholder="student dept" />
				<input id="submitStu" name="submitStu" value="Submit" type="submit" />
			</form>
		</div>
		<form id="logout" action="../logout/" method="post">
			<input id="logoutBtn" name="logoutBtn" value="logOut" type="submit" />
			<security:csrfInput/>
		</form>

	</body>

</html>