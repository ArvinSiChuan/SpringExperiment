<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>new student page</title>
	</head>

	<body>
		<div style="text-align: center;">
			<form  action="../new/" method="post">
				<input type="hidden" name="_method" value="PUT" />
				<label for="sno">Sno.:</label><input id="sno" name="sno" type="number" required="required"/><br />
				<label for="sname">Name:</label><input id="sname" name="sname" type="text" /><br />
				<label for="sdept">Dept:</label><input id="sdept" name="sdept" type="number" /><br />
				<input id="submit" value="submit" type="submit" /> <input id="reset" type="reset" value="reset" />
			</form>
		</div>
	</body>

</html>