<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>  
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../css/main.css" />
	</head>

	<body>

		<section id="main" class="wrapper" style="width: 25em;margin: auto;">
			<div id="loginform" style="margin:auto;"  style="width: 25em;">
				<form name="loginform" id="loginform" action="." method="post">
					<security:csrfInput/>
					
					<div class="6u 12u$(small)">
						<input type="text" name="name" id="name" placeholder="工号/邮箱" required="required" pattern="((\w)+(\.\w+)*@(\w)+((\.\w+)+))|([0-9]*)" title="请输入工号或邮箱" />
					</div>

					<div class="6u$ 12u$(small)" >
						<input type="password" name="pass" id="pass" placeholder="口令" required="required" title="请输入口令" />
					</div>

					<a id="fogetPass" href="#">忘记密码</a>

					<div class="12u$">
						<input type="submit" name="submit" id="submit" value="登录" />
					</div>
				</form>
			</div>
		</section>
	</body>

</html>