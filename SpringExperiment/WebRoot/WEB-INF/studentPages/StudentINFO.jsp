<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Student INFO</title>

  </head>
  
  <body>
  	<div style="margin:0 auto;">
		  <table style="margin:0 auto;">
		  	<tr><th colspan="3">Student INFO</th></tr>
				<tr>
						<th>NO.</th>
						<th>Name</th>
						<th>Dept</th>
						<th>Operation</th>
				</tr>
				<c:forEach var="stu"  items="${studentsList }">
						<tr>
							<td>${stu.sno }</td>
							<td>${stu.sname }</td>
							<td>${stu.sdept}</td>
							<td><a href="../${stu.sno}/delete/">delete</a></td>
						</tr>
				</c:forEach>
			</table>
			<p style="margin: 0 auto;text-align: center;">
				<a href="../new/">create new student</a>
			</p>
		</div>
	  </body>
	  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</html>
